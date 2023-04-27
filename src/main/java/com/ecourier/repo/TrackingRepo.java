package com.ecourier.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecourier.entity.CourierStatus;
import com.ecourier.entity.Tracking;





@Repository
public interface TrackingRepo extends JpaRepository<Tracking,Long > {
	List<Tracking> findByStatus(CourierStatus status);

	Tracking findByTrackingNumber(long trackingNumber);

	Tracking findByTrackingId(long trackingId);

	


	
}
