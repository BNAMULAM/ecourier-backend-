package com.ecourier.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.ecourier.entity.Tracking;
import com.ecourier.entity.TrackingDto;
import com.ecourier.entity.CourierStatus;
import com.ecourier.entity.CourierStatusDto;
import com.ecourier.service.TrackingService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/courier")
public class TrackingController {
	@Autowired
	private TrackingService trackingService;
	
	@PostMapping("/add")
	public TrackingDto addCouroerDetails(@Valid @RequestBody TrackingDto trackingDto) {
		return trackingService.addCourierDetails(trackingDto);
	}
	@PutMapping("/{trackingId}")
	public TrackingDto updateCourierStatus(@PathVariable long trackingId,@RequestBody CourierStatusDto status) {
		System.out.println(status);
		System.out.println(trackingId);
		return trackingService.updateCourierStatus(trackingId, status.getStatus());
	}
	@GetMapping("/{trackingId}")
	public TrackingDto trackCourier(@PathVariable long trackingNumber) {
		return trackingService.trackCourier(trackingNumber);
	}
	@GetMapping("/status/{status}")
	public List<TrackingDto> viewCourierByStatus(@PathVariable int status){
		CourierStatus c = CourierStatus.OUT_FOR_DELIVERY;
		System.out.println(status);
		if(status == 0) {
			c = CourierStatus.ORDER_PLACED;
		}
		else if(status ==1) {
			c = CourierStatus.IN_TRANSIT;
					
		}
		else if(status ==2) {
			c = CourierStatus.OUT_FOR_DELIVERY;
					
		}
		else if(status ==3) {
			c = CourierStatus.DISPATCHED;
					
		}
		else if(status ==4) {
			c = CourierStatus.DELIVERED;
					
		}
		else if(status ==5) {
			c = CourierStatus.RETURNED;
					
		}
		System.out.println(c);
		return trackingService.viewCourierByStatus(c);
	}
}













































































































