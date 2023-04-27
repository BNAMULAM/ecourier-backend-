package com.ecourier.service;

import java.util.List;
import com.ecourier.entity.CourierDetails;
import com.ecourier.entity.CourierStatus;
import com.ecourier.exception.CourierNotFoundException;
public interface CourierDetailsService {
public CourierDetails updateCourierStatus(long courierId, CourierStatus status);
public CourierDetails checkCourierDetails(long courierId) throws CourierNotFoundException;
public List<CourierDetails> viewAllCourier();
public CourierDetails addCourierDetails(CourierDetails courierdetails1);

}