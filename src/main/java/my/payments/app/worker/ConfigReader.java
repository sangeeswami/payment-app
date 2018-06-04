package my.payments.app.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigReader {
	
	private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
	
	@Value("${priceupdate.processor.threshold}")
	public static String processorThreshold;
	
	@Value("${priceupdate.processor.maxavailable}")
	public static String availableProcessorCount;
			
	@Value("${priceupdate.processor.maxavailable}")
	public static String processingChunkSize;
	
	@Value("${topic.priceupdate}")
	public static String TOPIC_PRICE_UPDATE;
	
	@Value("${topic.notifypriceupdate}")
	public static String TOPIC_NOTIFY_PRICE_UPDATE;
	
	@Value("${topic.notifypriceupdateack}")
	public static String TOPIC_PRICE_UPDATE_ACK;

	public static int getProcessorThreshold() {
		logger.info("processor threshold = >>" + processorThreshold + "<<");
		return 5;// Integer.parseInt(processorThreshold);
	}
	
	public static int getAvailableProcessorCount() {
		logger.info("processor threshold = >>" + availableProcessorCount + "<<");
		return 3; //Integer.parseInt(availableProcessorCount);
	}
	
	public static int getProcessingChunkSize() {
		logger.info("processor threshold = >>" + processingChunkSize + "<<");
		return 2; //Integer.parseInt(processingChunkSize);
	}

}
