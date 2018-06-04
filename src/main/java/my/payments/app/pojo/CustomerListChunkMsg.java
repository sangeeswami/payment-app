package my.payments.app.pojo;

import java.util.List;

import my.payments.app.dao.PriceInfo;

public class CustomerListChunkMsg {
	
	private List<String> customerIds;
	private PriceInfo priceInfo;
	
	public CustomerListChunkMsg() {
	}
	
	public CustomerListChunkMsg(List<String> customerIds, PriceInfo priceInfo) {
		this.customerIds = customerIds;
		this.priceInfo = priceInfo;
	}
	
	public List<String> getCustomerIds() {
		return this.customerIds;
	}
	public void setCustomerIds(List<String> customerIds) {
		this.customerIds = customerIds;
	}
	
	public PriceInfo getPriceInfo() {
		return this.priceInfo;
	}
	public void setPriceInfo(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

}
