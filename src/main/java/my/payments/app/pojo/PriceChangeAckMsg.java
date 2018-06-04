package my.payments.app.pojo;

public class PriceChangeAckMsg {
	
	private String customerId;
	private String priceUpdateId;
	
	public PriceChangeAckMsg() {
	}
	
	public PriceChangeAckMsg(String customerId, String priceUpdateId) {
		this.customerId = customerId;
		this.priceUpdateId = priceUpdateId;
	}
	
	public String getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getPriceUpdateId() {
		return this.priceUpdateId;
	}
	public void setPriceUpdateId(String priceUpdateId) {
		this.priceUpdateId = priceUpdateId;
	}

}
