package com.ecourier.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tracking")
public class Tracking {
		private long customerId;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//identity,sequence,table
		private long trackingId;
		private long trackingNumber;
		private String receivedAt;
		private CourierStatus status;
		
		public long getTrackingId() {
			return trackingId;
		}
		public void setTrackingId(long trackingId) {
			this.trackingId = trackingId;
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
		public Tracking(long customerId, long trackingNumber, String receivedAt, CourierStatus status) {
			super();
			this.customerId = customerId;
			this.trackingNumber = trackingNumber;
			this.receivedAt = receivedAt;
			this.status = status;
		}
		public Tracking() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "CourierDetails [customerId=" + customerId + ", trackingNumber=" + trackingNumber + ", receivedAt="
					+ receivedAt + ", status=" + status + "]";
		}
		
}
