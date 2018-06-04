package my.payments.app.dao;

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
	
	@Query("select c.email from Customer c where c.status='ACTIVE' and c.planCode=:planCode and c.countryCode=:countryCode")
	List<String> findCustomerIdsByPlanIdCountryCodeAndBilldate(
			@Param("planCode") String planCode,
			@Param("countryCode") String countryCode);

}