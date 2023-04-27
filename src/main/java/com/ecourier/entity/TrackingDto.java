package com.ecourier.entity;




import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
@Builder
public class TrackingDto {
	//@Min(value = 1, message = "Customer Id must be a positive number")
	//@Max(value=5,message = "customer id must be 5 numbers")
    private long customerId;

    @Min(value = 1, message = "Tracking Id must be a positive number")
    private long trackingId;

    @Min(value = 1, message = "Tracking Number must be a positive number")
    private long trackingNumber;

    @NotNull(message = "Received At cannot be null")
    @Size(min = 1, message = "Received At must not be empty")
    private String receivedAt;

    @NotNull(message = "Status cannot be null")
    private CourierStatus status;

	public TrackingDto(long customerId, long trackingId, long trackingNumber, String receivedAt, CourierStatus status) {
		super();
		this.customerId = customerId;
		this.trackingId = trackingId;
		this.trackingNumber = trackingNumber;
		this.receivedAt = receivedAt;
		this.status = status;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(long trackingId) {
		this.trackingId = trackingId;
	}
	public long getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(long trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public String getReceivedAt() {
		return receivedAt;
	}
	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}
	public CourierStatus getStatus() {
		return status;
	}
	public void setStatus(CourierStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TrackingDto [customerId=" + customerId + ", trackingId=" + trackingId + ", trackingNumber="
				+ trackingNumber + ", receivedAt=" + receivedAt + ", status=" + status + "]";
	}
	public TrackingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

