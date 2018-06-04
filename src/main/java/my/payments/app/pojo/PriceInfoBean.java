package my.payments.app.pojo;

public class PriceInfoBean {
	
	private String planCode;
	private String countryCode;
	private Double price;
	private String status;
	private String rolloutStatus;

	public String getPlanCode() {
		return this.planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	
	public String getCountryCode() {
		return this.countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public Double getPrice() {
		return this.price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRolloutStatus() {
		return this.rolloutStatus;
	}
	public void setRolloutStatus(String rolloutStatus) {
		this.rolloutStatus = rolloutStatus;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Plan Code: " + planCode)
			.append("\nCountry Code: " + countryCode)
			.append("\nPrice: " + price)
			.append("\nStatus: " + status)
			.append("\nRollout Status: " + rolloutStatus);
		
		return builder.toString();
	}
}