package my.payments.app.worker;


import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import my.payments.app.controller.PriceInfoController;
import my.payments.app.dao.CustomerRepository;
import my.payments.app.dao.PriceInfo;
import my.payments.app.dao.PriceInfoRepository;
import my.payments.app.pojo.ApplicationConstants;
import my.payments.app.pojo.CustomerListChunkMsg;

@Configuration
@Service
public class PriceUpdateCheckerImpl implements PriceUpdateChecker {
	
	@Autowired
	PriceInfoRepository priceInfoRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	ApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(PriceInfoController.class);

	@Override
	public Boolean checkForPriceUpdates(LocalDate priceCheckerDate) {
		
		logger.info("Start... checkForPriceUpdates");

		//1. Check if there are price updates to apply
		List<PriceInfo> priceInfoList = priceInfoRepo.findPendingPriceUpdates();
		
		logger.info("Number of price updates to process = " + priceInfoList.size());
		
		for (PriceInfo pendingUpdate : priceInfoList) {
			// Are any customers on old price plans?
			Boolean allCustomersUpgraded = !customerRepo.allCustomersNotUpgraded(
					pendingUpdate.getPlanCode(), 
					pendingUpdate.getCountryCode(),
					pendingUpdate.getPriceId());
			
			if (allCustomersUpgraded.booleanValue()) {
				pendingUpdate.setRolloutStatus("COMPLETE");
				priceInfoRepo.save(pendingUpdate);
				priceInfoRepo.markOldPricesObsolete(pendingUpdate.getPlanCode(), 
						pendingUpdate.getCountryCode(),
						pendingUpdate.getPriceId());
				break;
			}
			
			logger.info("Processing priceUpdate: " + pendingUpdate.toString());
			
			List<String> customerList = customerRepo.findCustomerIdsByPlanIdCountryCodeAndDayInterval(
					pendingUpdate.getPlanCode(), 
					pendingUpdate.getCountryCode(),
					priceCheckerDate.plusDays(30));
			
			int totalCustomers = customerList.size();
			logger.info("Number of customers affected = " + customerList.size());
			
			if (totalCustomers == 0) {
				break;
			}
			
			//If count is more than 0:
			//Find number of servers needed and start the servers - totalRecords/ConfigReader.processorThreshold
			int perProcessorThreshold = ConfigReader.getProcessorThreshold();
			int requiredNumberOfWorkers =  totalCustomers/perProcessorThreshold;
			logger.info("Number of processors to start = " + requiredNumberOfWorkers);
			for (int idx=0; idx < requiredNumberOfWorkers; idx++) {
				//Start that many PriceUpdateProcessor threads and store numberOfWorkers
				
			}
			
			int chunkSize = ConfigReader.getProcessingChunkSize();
			int currentStartIndex = 0;
			while (currentStartIndex < totalCustomers) {
				int currentEndIndex = currentStartIndex + chunkSize;
				if (currentEndIndex > totalCustomers) {
					currentEndIndex = totalCustomers;
				}
				//Construct a message with chunkSize Ids and put them in messaging queue
				logger.info("Chunk startIndex = " + currentStartIndex);
				CustomerListChunkMsg chunkMsg = new CustomerListChunkMsg();
				chunkMsg.setPriceInfo(pendingUpdate);
				chunkMsg.setCustomerIds(customerList.subList(currentStartIndex, currentEndIndex));
				
				
				//Send message to queue
				JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		        jmsTemplate.convertAndSend(ApplicationConstants.TOPIC_PRICE_UPDATE, 
		        		chunkMsg);
		        logger.info("Chunk posted to topic, start=" + 
		        		currentStartIndex + ", end=" + currentEndIndex);
				
				currentStartIndex = currentEndIndex;
			}
		}
		
		logger.info("checkForPriceUpdates ... done");
		return Boolean.valueOf(priceInfoList.size() == 0);
	}
}
