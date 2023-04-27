package com.ecourier.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecourier.entity.AppUser;
import com.ecourier.entity.AppUserModel;
import com.ecourier.entity.LoginResponseDto;
import com.ecourier.repo.AppUserRepo;
import com.ecourier.service.AppUserService;
@Service
public class AppUserServiceImpl implements AppUserService {
	@Autowired
	private AppUserRepo appUserRepo;




	@Override
	public AppUser register(AppUser appUser) {
		this.appUserRepo.save(appUser);
		return appUser;
	}




	@Override
	public LoginResponseDto login(String userName, String password) {
		Optional<AppUser> login = appUserRepo.findByUserName(userName);
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		if(login.isPresent() ) {
			AppUser user = login.get();
			if(login.get().getPassword().equals(password)) {
				loginResponseDto.setUserName(userName);
				loginResponseDto.setMessage("Login Successfull");
				loginResponseDto.setRole(user.getRole());
				
			}
			else {
				loginResponseDto.setMessage("Invalid Username or password");
			}
			
		}
		else {
			loginResponseDto.setMessage("Not Registered");
		}
		return loginResponseDto;
	}
}
