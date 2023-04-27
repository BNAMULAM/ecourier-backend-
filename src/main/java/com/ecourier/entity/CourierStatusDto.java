package com.ecourier.entity;

public class CourierStatusDto {
	private CourierStatus status;

	public CourierStatus getStatus() {
		return status;
	}

	public void setStatus(CourierStatus status) {
		this.status = status;
	}

	public CourierStatusDto(CourierStatus status) {
		super();
		this.status = status;
	}

	@Override
	public String toString() {
		return "CourierStatusDto [status=" + status + "]";
	}

	public CourierStatusDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
