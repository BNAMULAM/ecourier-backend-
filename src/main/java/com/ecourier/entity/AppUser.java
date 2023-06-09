package com.ecourier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class AppUser {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

private int userid;
@Column(unique=true)
private String userName;

private String password;
private long mobileNumber;
private Role role;

public String getUserName() {
    return userName;
}
public void setUserName(String userName) {
    this.userName = userName;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public long getMobileNumber() {
    return mobileNumber;
}
public void setMobileNumber(long mobileNumber) {
    this.mobileNumber = mobileNumber;
}


public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
@Override
public String toString() {
	return "AppUser [userid="  + ", userName=" + userName + ", password=" + password + ", mobileNumber="
			+ mobileNumber + ", role=" + role + "]";
}
public AppUser( String userName, String password, long mobileNumber, Role role) {
	super();
	
	this.userName = userName;
	this.password = password;
	this.mobileNumber = mobileNumber;
	this.role = role;
}
public AppUser() {
    super();
    // TODO Auto-generated constructor stub
}

 

}
