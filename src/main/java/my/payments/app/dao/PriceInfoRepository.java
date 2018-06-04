package my.payments.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceInfoRepository extends CrudRepository<PriceInfo, Long> {
	
	List<PriceInfo> findAll();
	
	@Query("select p from PriceInfo p where p.status='ACTIVE' and p.rolloutStatus='PENDING'")
	List<PriceInfo> findPendingPriceUpdates();

}
