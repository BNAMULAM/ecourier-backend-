package com.ecourier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecourier.entity.CourierDetails;
import com.ecourier.entity.CourierStatus;
import com.ecourier.entity.CourierStatusDto;
import com.ecourier.exception.CourierNotFoundException;
import com.ecourier.service.CourierDetailsService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/courierdetails")
public class CourierDetailsController {
@Autowired
private CourierDetailsService service;
@PutMapping("/update/{courierId}/{status}")
public CourierDetails updateCourierStatus( @PathVariable ("courierId") long courierId , @PathVariable("status") int status) {
    CourierStatus c_status = null;
	
	System.out.println(status);
	
	
	 if(status==0)
	 {
		 c_status = CourierStatus.ORDER_PLACED;
		 
	 }else if(status==1)
	 {
		 c_status = CourierStatus.IN_TRANSIT;
		 
	 }else if(status==2)
	 {
		 c_status = CourierStatus.OUT_FOR_DELIVERY;
		 
	 }else if(status==3)
	 {
		 c_status = CourierStatus.DISPATCHED;
		 
	 }else if(status==4)
	 {
		 c_status = CourierStatus.DELIVERED;
		 
	 }else if(status==5)
	 {
		 c_status = CourierStatus.RETURNED;
		 
	 }
	  
	return this.service.updateCourierStatus(courierId,c_status); 
}
@GetMapping("/check/{courierid}")
public CourierDetails checkCourierDetails(@PathVariable("courierid")long courierId) throws CourierNotFoundException {
    CourierDetails check = this.service.checkCourierDetails(courierId);
    return check;
}
@PostMapping("/add")
public CourierDetails addCourierDetails(@RequestBody CourierDetails courierdetails ) {
    CourierDetails addCourierDetails = this.service.addCourierDetails(courierdetails);
    return addCourierDetails;
}
@GetMapping("/view")
public List<CourierDetails> viewAllCourier(){
    List<CourierDetails> viewAllCourier = this.service.viewAllCourier();
    return viewAllCourier;
}
}
