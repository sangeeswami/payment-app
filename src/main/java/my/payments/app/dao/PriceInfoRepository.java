package my.payments.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PriceInfoRepository extends CrudRepository<PriceInfo, Long> {
	
	List<PriceInfo> findAll();
	
	@Query("select p from PriceInfo p where p.status='ACTIVE' and p.rolloutStatus='PENDING'")
	List<PriceInfo> findPendingPriceUpdates();
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update PriceInfo p set p.status='OBSOLETE' where p.planCode=:planCode and p.countryCode=:countryCode and p.priceId != :priceId")
	void markOldPricesObsolete(@Param("planCode") String planCode,
			@Param("countryCode") String countryCode,
			@Param("priceId") Long priceId);

}
