package com.ecourier.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecourier.entity.AppUser;
import com.ecourier.entity.AppUserModel;
import com.ecourier.entity.LoginResponseDto;
import com.ecourier.service.AppUserService;
@CrossOrigin(origins="http://localhost:3000")
@RestController //controller and response body
@RequestMapping("/users")
public class AppUserController{
	@Autowired
	private AppUserService appUserService;
	@PostMapping("/login")
	public LoginResponseDto login(@RequestParam String userName, @RequestParam String password) {
		return appUserService.login(userName,password);
	}
	
	@PostMapping("/register")
	public AppUser register(@RequestBody AppUser appUser) {
		return this.appUserService.register(appUser);
	}
	

}
































    