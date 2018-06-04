package my.payments.app.worker;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import my.payments.app.controller.PriceInfoController;
import my.payments.app.dao.Customer;
import my.payments.app.dao.CustomerRepository;
import my.payments.app.dao.PriceInfo;
import my.payments.app.pojo.ApplicationConstants;
import my.payments.app.pojo.CustomerListChunkMsg;
import my.payments.app.pojo.PriceChangeNotificationMsg;

@Service
public class PriceUpdateChunkProcessImpl implements PriceUpdateChunkProcessor, Runnable {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	ApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(PriceUpdateChunkProcessImpl.class);

	@Override
	@JmsListener(destination=ApplicationConstants.TOPIC_PRICE_UPDATE, containerFactory="myFactory")
	public void processChunk(CustomerListChunkMsg msg) {
		
		logger.info("Processing Chunk ["
				+ msg.getCustomerIds().get(0) + ", "
				+ msg.getCustomerIds().get(msg.getCustomerIds().size()-1) + "]");
		
		//For each customer id, get the customer info and construct PriceChangeNotificationMsg 
		
		PriceInfo priceInfo = msg.getPriceInfo();
		
		for (String customerId : msg.getCustomerIds()) {
			Optional<Customer> opt = customerRepo.findById(customerId);
			Customer customer = opt.get();
			
			logger.info("Constructing email body for: " + customer.getEmail());
			PriceChangeNotificationMsg notifyMsg = new PriceChangeNotificationMsg(
					priceInfo.getPriceId(),
					customer.getEmail(), 
					getMessageBody(customer, priceInfo));
			
			//Send message to queue
			JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
	        jmsTemplate.convertAndSend(ApplicationConstants.TOPIC_PRICE_UPDATE_NOTIFY, 
	        		notifyMsg);
	        logger.info("Pushed email to jms for customer: " + customer.getEmail());
		}
	}
	
	private String getMessageBody(Customer customer, PriceInfo priceInfo) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Hello " + customer.getCustomerName())
			.append(",\n  Please be awware of new price " + priceInfo.getPrice().toString())
			.append(" starting next billing cycle starting " + customer.getNextBilldate().toString());
		
		return builder.toString();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
