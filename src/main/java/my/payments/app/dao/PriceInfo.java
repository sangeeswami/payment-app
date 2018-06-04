package my.payments.app.dao;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class PriceInfo {
	
	@Id
	@SequenceGenerator(name= "PRICE_INFO_SEQUENCE", sequenceName = "PRICE_INFO_SEQUENCE_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="PRICE_INFO_SEQUENCE")
	private Long priceId;
	private String planCode;
	private String countryCode;
	private Double price;
	private Timestamp effectiveDate;
	private String status;
	private String rolloutStatus;
	
	public Long getPriceId() {
		return this.priceId;
	}
	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}
	
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
	
	public Timestamp getEffectiveDate() {
		return this.effectiveDate;
	}
	public void setEffectiveDate(Timestamp effectiveDate) {
		this.effectiveDate = effectiveDate;
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
		builder.append("Price id: " + this.priceId)
			.append("\nPlan cpde: " + this.planCode)
			.append("\nCountry code: " + this.countryCode)
			.append("\nPrice: " + this.price);
		
		return builder.toString();
	}
}
