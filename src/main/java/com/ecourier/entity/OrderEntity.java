package com.ecourier.entity;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long trackingNumber;
    private String name;
    private String address;
    private long mobileNo;
    private String fromLocation;
    private long fromPinCode;
    private String toLocation;
    private long toPinCode;
    private double amount;
    
    public Long getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(Long trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public OrderEntity(Long trackingNumber, String name, String address, long mobileNo, String fromLocation,
            long fromPinCode, String toLocation, long toPinCode, double amount) {
        super();
        this.name = name;
        this.address = address;
        this.mobileNo = mobileNo;
        this.fromLocation = fromLocation;
        this.fromPinCode = fromPinCode;
        this.toLocation = toLocation;
        this.toPinCode = toPinCode;
        this.amount = amount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getFromLocation() {
        return fromLocation;
    }
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }
    public long getFromPinCode() {
        return fromPinCode;
    }
    public void setFromPinCode(long fromPinCode) {
        this.fromPinCode = fromPinCode;
    }
    public String getToLocation() {
        return toLocation;
    }
    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }
    public long getToPinCode() {
        return toPinCode;
    }
    public void setToPinCode(long toPinCode) {
        this.toPinCode = toPinCode;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public OrderEntity() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	public String toString() {
		return "OrderEntity [trackingNumber=" + trackingNumber + ", name=" + name + ", address=" + address
				+ ", mobileNo=" + mobileNo + ", fromLocation=" + fromLocation + ", fromPinCode=" + fromPinCode
				+ ", toLocation=" + toLocation + ", toPinCode=" + toPinCode + ", amount=" + amount + "]";
	}
  
}