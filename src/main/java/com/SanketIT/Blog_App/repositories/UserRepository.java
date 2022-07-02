package com.SanketIT.Blog_App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SanketIT.Blog_App.model.Users;

public interface UserRepository  extends JpaRepository<Users, Integer>{
	

}
