package my.payments.app.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.stereotype.Service;

import my.payments.app.pojo.CustomerListChunkMsg;

public interface PriceUpdateChunkProcessor {

	@JmsListener(destination="priceupdate", containerFactory="myFactory")
	public void processChunk(CustomerListChunkMsg msg);
}
