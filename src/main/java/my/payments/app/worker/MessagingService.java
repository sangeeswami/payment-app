package my.payments.app.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.stereotype.Service;

import my.payments.app.pojo.ApplicationConstants;

@Service
public class MessagingService  {
	
	private static final Logger logger = LoggerFactory.getLogger(MessagingService.class);

	public SimpleJmsListenerEndpoint getEndpoint() {
		SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
		
	    endpoint.setId(ApplicationConstants.TOPIC_PRICE_UPDATE + 1);
	    endpoint.setDestination(ApplicationConstants.TOPIC_PRICE_UPDATE);
	    endpoint.setMessageListener(message -> {
	    		logger.info("SANGEE MESSAGE RECEIVED ... " + message);	
	    });
	    
	    return endpoint;
	}
}
