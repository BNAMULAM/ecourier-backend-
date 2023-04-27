package com.ecourier.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="courierdetails")
public class CourierDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courierId;
    private long customerId;
    private long trackingNumber;
    private String recievedAt;
    private CourierStatus status;
    public CourierDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
    public CourierDetails(long courierId, long customerId, long trackingNumber, String recievedAt,
            CourierStatus status) {
        super();
        this.courierId = courierId;
        this.customerId = customerId;
        this.trackingNumber = trackingNumber;
        this.recievedAt = recievedAt;
        this.status = status;
    }
    public long getCourierId() {
        return courierId;
    }
    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }
    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public long getTrackingNumber() {
        return trackingNumber;
    }
    public void setTrackingNumber(long trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
    public String getRecievedAt() {
        return recievedAt;
    }
    public void setRecievedAt(String recievedAt) {
        this.recievedAt = recievedAt;
    }
    public CourierStatus getStatus() {
        return status;
    }
    public void setStatus(CourierStatus status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "CourierDetails [courierId=" + courierId + ", customerId=" + customerId + ", trackingNumber="
                + trackingNumber + ", recievedAt=" + recievedAt + ", status=" + status + "]";
    }


}