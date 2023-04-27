package com.ecourier.exception;
public class CourierNotFoundException extends RuntimeException {
	public CourierNotFoundException(String msg) {
		super(msg);
	}
}
