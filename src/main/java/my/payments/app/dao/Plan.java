package my.payments.app.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plan {
	
	@Id
	private String planCode;
	private String planName;
	
	public String getPlanCode() {
		return this.planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	
	public String getPlanName() {
		return this.planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}

}
