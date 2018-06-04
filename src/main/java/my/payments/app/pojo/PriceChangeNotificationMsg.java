package my.payments.app.pojo;

public class PriceChangeNotificationMsg {
	
	private Long priceId;
	private String to;
	private String body;
	
	public PriceChangeNotificationMsg() {
	}
	
	public PriceChangeNotificationMsg(Long priceId) {
		this.priceId = priceId;
	}
	
	public PriceChangeNotificationMsg(String to, String body) {
		this.to = to;
		this.body = body;
	}
	
	public PriceChangeNotificationMsg(Long priceId, String to, String body) {
		this.priceId = priceId;
		this.to = to;
		this.body = body;
	}
	
	public Long getPriceId() {
		return this.priceId;
	}
	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}
	
	
	public String getTo() {
		return this.to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getBody() {
		return this.body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
    public String toString() {
        return String.format("Email{to=%s, body=%s}", getTo(), getBody());
    }
	
}
