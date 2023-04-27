package com.ecourier.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecourier.entity.Tracking;
import com.ecourier.entity.CourierDetails;
import com.ecourier.entity.CourierStatus;
import com.ecourier.exception.CourierNotFoundException;
import com.ecourier.repo.CourierDetailsRepo;
import com.ecourier.service.CourierDetailsService;

@Service
public class CourierDetailsServiceImpl implements CourierDetailsService {

	@Autowired
	private CourierDetailsRepo repo1;

	@Override
	public CourierDetails updateCourierStatus(long courierId,CourierStatus status) {
		//CourierDetails courierDetails = this.repo1.findById(courierId).get();
		CourierDetails courierDetails = repo1.findByCourierId(courierId);
		
//		CourierDetails1 c = new CourierDetails1();
//		c.setCustomerId(courierDetails.getCustomerId());
//		c.setRecievedAt(courierDetails.getRecievedAt());
//		c.setTrackingNumber(courierDetails.getTrackingNumber());
//		courierDetails.setCourierId(courierId);
		courierDetails.setStatus(status);
		return this.repo1.save(courierDetails);

}
		@Override
		public CourierDetails checkCourierDetails(long courierId) throws CourierNotFoundException{
			Optional<CourierDetails> courierDetails1 = repo1.findById(courierId);
		if(courierDetails1.isPresent()) {
		return courierDetails1.get();
		}
		else {
		throw new CourierNotFoundException("Courier Not Found");
		}
}
		@Override
		public List<CourierDetails> viewAllCourier() {
		List<CourierDetails> findAll = repo1.findAll();
		return findAll;
		}
		
		@Override
		public CourierDetails addCourierDetails(CourierDetails courierdetails1) {
			return repo1.save(courierdetails1);
		}

}