package com.ecourier.service;

import java.util.List;

import com.ecourier.entity.CourierStatus;
import com.ecourier.entity.TrackingDto;
import com.ecourier.exception.CourierNotFoundException;
import com.ecourier.exception.TrackingNotFoundException;




public interface TrackingService{
	TrackingDto addCourierDetails(TrackingDto tracking);
	List<TrackingDto> viewCourierByStatus(CourierStatus status);
	TrackingDto updateCourierStatus(long trackingNumber,CourierStatus status) throws TrackingNotFoundException;
	TrackingDto trackCourier (long trackingNumber) throws CourierNotFoundException;
}

























































