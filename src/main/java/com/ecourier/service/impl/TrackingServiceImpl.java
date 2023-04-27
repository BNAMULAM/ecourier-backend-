package com.ecourier.service.impl;



import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecourier.entity.CourierStatus;
import com.ecourier.entity.Tracking;
import com.ecourier.entity.TrackingDto;
import com.ecourier.exception.CourierNotFoundException;
import com.ecourier.exception.TrackingNotFoundException;
import com.ecourier.repo.TrackingRepo;
import com.ecourier.service.TrackingService;



@Service
public class TrackingServiceImpl implements TrackingService{

	    @Autowired
	    private TrackingRepo trackingRepository;

	        
	        @Override
	        public TrackingDto addCourierDetails(@Valid TrackingDto courierDTO) {
	            try {
	                // Create entity from DTO
	                Tracking courierEntity = new Tracking();
	                courierEntity.setCustomerId(courierDTO.getCustomerId());
	                courierEntity.setTrackingId(courierDTO.getTrackingId());
	                courierEntity.setReceivedAt(courierDTO.getReceivedAt());
	                courierEntity.setTrackingNumber(courierDTO.getTrackingNumber());
	                courierEntity.setStatus(courierDTO.getStatus());

	                // Save to repository
	                trackingRepository.save(courierEntity);

	                // Create DTO from entity
	                return new TrackingDto(courierEntity.getCustomerId(), courierEntity.getTrackingId(),courierEntity.getTrackingNumber(),
	                                      courierEntity.getReceivedAt(), courierEntity.getStatus());
	            } catch (Exception e) {
	                throw new RuntimeException("Error occurred while saving courier details", e);
	            }
	        }

	        @Override
	        public TrackingDto updateCourierStatus(long trackingId, CourierStatus status) {
//	        	System.out.println(status);
//	        	System.out.println("***");
//	        	System.out.println(trackingId);
	            try {
	                // Find entity by trackingId
	                Tracking courierEntity = trackingRepository.findByTrackingId(trackingId);
	                System.out.println(courierEntity);
	                System.out.println("***");
	                if (courierEntity == null) {
	                    throw new CourierNotFoundException("Courier not found with trackingId: " + trackingId);
	                }

	                // Update status
	                courierEntity.setStatus(status);
	                trackingRepository.save(courierEntity);

	                // Create DTO from entity
	                return new TrackingDto(courierEntity.getCustomerId(), courierEntity.getTrackingId(),courierEntity.getTrackingNumber(),
	                                      courierEntity.getReceivedAt(), courierEntity.getStatus());
	            } catch (Exception e) {
	                throw new RuntimeException("Error occurred while updating courier status", e);
	            }
	        }
	        @Override
	        public TrackingDto trackCourier(long trackingId) throws TrackingNotFoundException {
	        try {
	            // Find entity by trackingId
	            Tracking courierEntity = trackingRepository.findByTrackingNumber(trackingId);
	            if (courierEntity == null) {
	                throw new TrackingNotFoundException("Tracking not found with trackingId: " + trackingId);
	            }
	            // Create DTO from entity
	            return new TrackingDto(courierEntity.getCustomerId(), courierEntity.getTrackingId(),courierEntity.getTrackingNumber(),
	                                  courierEntity.getReceivedAt(), courierEntity.getStatus());
	        } catch (Exception e) {
	            throw new RuntimeException("Error occurred while tracking courier", e);
	        }
	    }

	    @Override
	    public List<TrackingDto> viewCourierByStatus(CourierStatus status) {
	        try {
	            List<Tracking> courierEntities = trackingRepository.findByStatus(status);
	            System.out.println(status);
	            System.out.println(courierEntities);
	            List<TrackingDto> courierDTOs = new ArrayList<>();
	            for (Tracking courierEntity : courierEntities) {
	                // Create DTO from entity
	                courierDTOs.add(new TrackingDto(courierEntity.getCustomerId(), courierEntity.getTrackingId(),courierEntity.getTrackingNumber(),
	                                              courierEntity.getReceivedAt(), courierEntity.getStatus()));
	            }
	            return courierDTOs;
	        } catch (Exception e) {
	            throw new RuntimeException("Error occurred while viewing couriers by status", e);
	        }
	    }


}    
	