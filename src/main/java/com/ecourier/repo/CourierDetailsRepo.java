package com.ecourier.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecourier.entity.CourierDetails;

@Repository
public interface CourierDetailsRepo extends JpaRepository<CourierDetails, Long>{

	CourierDetails findByCourierId(long courierId);
	
}

 