package my.payments.app.dao;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private String email;
	private String customerName;
	private String planCode;
	private String countryCode;
	private Long priceId;
	private LocalDate onboardDate;
	private LocalDate nextBilldate;
	private String status;
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getPlanCpde() {
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
	
	public Long getPriceId() {
		return this.priceId;
	}
	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}
	
	public LocalDate getOnboardDate() {
		return this.onboardDate;
	}
	public void setOnboardDate(LocalDate onboardDate) {
		this.onboardDate = onboardDate;
	}
	
	public LocalDate getNextBilldate() {
		return this.nextBilldate;
	}
	public void setNextBilldate(LocalDate nextBilldate) {
		this.nextBilldate = nextBilldate;
	}
	
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}