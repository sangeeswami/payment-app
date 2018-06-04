package my.payments.app.worker;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import my.payments.app.pojo.ApplicationConstants;
import my.payments.app.pojo.PriceChangeNotificationMsg;

@Service
public class PriceChangeNotificationReceiver {
	
	@Autowired
	ApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(PriceUpdateChunkProcessImpl.class);
	
	@JmsListener(destination=ApplicationConstants.TOPIC_PRICE_UPDATE_NOTIFY, containerFactory="myFactory")
	public void receiveMessage(PriceChangeNotificationMsg msg) {
		
		logger.info("Email sent to: " + msg.getTo() + ": " + msg.getBody());
		
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
		}
		
		//Send acknowledgement
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend(ApplicationConstants.TOPIC_PRICE_UPDATE_ACK, 
        		msg);
        
        logger.info("Pushed ack message to jms: " + msg.getTo());

	}

}
