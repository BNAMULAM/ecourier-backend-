package com.ecourier.service;

import com.ecourier.entity.AppUser;
import com.ecourier.entity.AppUserModel;
import com.ecourier.entity.LoginResponseDto;

public interface AppUserService{
	LoginResponseDto login( String userName,String password);
	AppUser register(AppUser appUser);
}






