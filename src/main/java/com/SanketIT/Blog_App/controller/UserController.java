package com.SanketIT.Blog_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SanketIT.Blog_App.payloads.ApiResponse;
import com.SanketIT.Blog_App.payloads.UsersDto;
import com.SanketIT.Blog_App.services.UserServicesI;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserServicesI userServicesI;

	// post Method-- create new record in data base
	@PostMapping("/")
	public ResponseEntity<UsersDto> saveUser(@RequestBody UsersDto usersDto) {

		UsersDto createUser = userServicesI.createUser(usersDto);

		return new ResponseEntity<UsersDto>(createUser, HttpStatus.CREATED);
	}

	// PUT Method use to update some record in data base
	
	@PutMapping("/{id}")
	public ResponseEntity<UsersDto> updateUser(@RequestBody UsersDto usersDto,@PathVariable Integer id) {
		UsersDto updateUser = userServicesI.updateUser(usersDto, id);

		return new ResponseEntity<UsersDto>(updateUser, HttpStatus.OK);
	}

	// GET method use to get All Data
	@GetMapping("/")
	public ResponseEntity<List<UsersDto>> getAllUser() {

		return ResponseEntity.ok(this.userServicesI.getAllUser());
	}
// GET Method  use to get record by ID
	@GetMapping("/{id}")
	public ResponseEntity<UsersDto> getUserById(@PathVariable Integer id){
		UsersDto userById = this.userServicesI.getUserById(id);
		return new ResponseEntity<>(userById, HttpStatus.OK);	
	}
	
	// DELETE method use delete record from data base
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteuserById(@PathVariable Integer id){
		this.userServicesI.deleteUserById(id);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User delete successfully",true),HttpStatus.OK);
		
	}
	
}
