package my.payments.app.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.payments.app.dao.PriceInfo;
import my.payments.app.dao.PriceInfoRepository;
import my.payments.app.pojo.PriceInfoBean;
import my.payments.app.worker.PriceUpdateChecker;

@Controller
public class PriceInfoController {
	
	@Autowired
	PriceUpdateChecker priceUpdateChecker;
	
	@Autowired
	PriceInfoRepository priceInfoRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(PriceInfoController.class);
	
	@RequestMapping(value="/priceinfo", method= RequestMethod.POST)
	public ResponseEntity<PriceInfoBean> updatePriceInfo(@RequestBody PriceInfoBean priceInfo) {
		
		logger.info("Received price update: " + priceInfo.toString());
		
		PriceInfo newPriceInfo = new PriceInfo();
		if (priceInfo != null) {
			
			newPriceInfo.setPlanCode(priceInfo.getPlanCode());
			newPriceInfo.setCountryCode(priceInfo.getCountryCode());
			newPriceInfo.setStatus("ACTIVE");
			newPriceInfo.setRolloutStatus("PENDING");
			newPriceInfo.setPrice(priceInfo.getPrice());
			PriceInfo savedPriceInfo = priceInfoRepo.save(newPriceInfo);
			
			logger.info("Saved price update to DB: " + savedPriceInfo.toString());
		}
		
		return new ResponseEntity<PriceInfoBean>(priceInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value="/schedulePriceChecker", method=RequestMethod.POST)
	public ResponseEntity<Boolean> startPriceChecker(@RequestBody String strDate) {
		logger.info("Calling price checker for date: " + strDate);
		//Date fromDate = Date.valueOf(strDate);
		LocalDate today = LocalDate.parse(strDate);
		Boolean priceUpdatesAvailable = priceUpdateChecker.checkForPriceUpdates(today);
		return new ResponseEntity<Boolean>(priceUpdatesAvailable, HttpStatus.OK);
		//return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.OK);
	}
	
}
