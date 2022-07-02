package com.SanketIT.Blog_App.services;

import java.util.List;

import com.SanketIT.Blog_App.payloads.UsersDto;

public interface UserServicesI {
	
	UsersDto createUser(UsersDto usersDto);
	UsersDto updateUser(UsersDto usersDto,Integer id);
	UsersDto getUserById(Integer id);
	List<UsersDto> getAllUser();
	void deleteUserById(Integer id);
	

}
