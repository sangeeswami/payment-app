package my.payments.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
	
	@Query("select c from Customer c where c.status='ACTIVE' and c.planCode=:planCode and c.countryCode=:countryCode")
	List<Customer> findCustomersByPlanIdAndBilldate(@Param("planCode") String planCode,
			@Param("countryCode") String countryCode);
	
	@Query("select c.email from Customer c where c.status='ACTIVE' and c.planCode=:planCode and c.countryCode=:countryCode and c.nextBilldate=:nextBilldate")
	List<String> findCustomerIdsByPlanIdCountryCodeAndDayInterval(
			@Param("planCode") String planCode,
			@Param("countryCode") String countryCode,
			@Param("nextBilldate") LocalDate nextBilldate);
	
	@Query("select count(c) > 0 from Customer c where c.status='ACTIVE' and c.planCode=:planCode and c.countryCode=:countryCode and c.priceId != :priceId")
	Boolean allCustomersNotUpgraded (
			@Param("planCode") String planCode,
			@Param("countryCode") String countryCode,
			@Param("priceId") Long priceId);
	

}