package my.payments.app.worker;

import java.time.LocalDate;

public interface PriceUpdateChecker {
	
	public Boolean checkForPriceUpdates(LocalDate fromDate);

}
