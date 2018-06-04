package my.payments.app.worker;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import my.payments.app.dao.Customer;
import my.payments.app.dao.CustomerRepository;
import my.payments.app.pojo.ApplicationConstants;
import my.payments.app.pojo.PriceChangeNotificationMsg;

@Component
public class PriceChangeAckReceiver {
	
	@Autowired
	CustomerRepository customerRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(PriceChangeAckReceiver.class);
	
	@JmsListener(destination=ApplicationConstants.TOPIC_PRICE_UPDATE_ACK, containerFactory="myFactory")
	public void receiveAcknowledgement(PriceChangeNotificationMsg msg) {
		
		logger.info("Received ack for customer: " + msg.getTo());
		
		//Update customer with new price	
		Optional<Customer> opt = customerRepo.findById(msg.getTo());
		Customer customer = opt.get();
		logger.info("Fetched customer from db with price: " + msg.getTo() + ", priceId " + customer.getPriceId());
		
		customer.setPriceId(msg.getPriceId());
		Customer savedCustomer = customerRepo.save(customer);
		logger.info("Price updated for customer: " + savedCustomer.getEmail() + ", priceId " + savedCustomer.getPriceId());
	}

}
