package com.ecourier.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecourier.entity.AppUser;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,String>{

	Optional<AppUser> findByUserName(String userName);

	
	

}