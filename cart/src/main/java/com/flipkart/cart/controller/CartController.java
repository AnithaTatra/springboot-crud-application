package com.flipkart.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.cart.entity.UserEntity;
import com.flipkart.cart.model.UserRequestDto;
import com.flipkart.cart.model.UserResponseDto;
import com.flipkart.cart.repository.UserRepository;
import com.flipkart.cart.service.UserData;

@RestController
public class CartController {
	@Autowired
	private UserData user;
	@Autowired
	UserRepository userrepository;
	
	@PostMapping("/addNewUser")
	public UserResponseDto addUser(@RequestBody UserRequestDto userrequestDto) {
		UserResponseDto userresponseDto = user.userDetails(userrequestDto);
		 return userresponseDto;
	}
	
    @GetMapping("/getUserDetails")
	public List<UserEntity> getUserData() {
    	List<UserEntity> entity = user.getUserData();
    	return entity;
    
    }
    @PutMapping("/updateUserDetails")
    public UserResponseDto UpdateUserDate(@RequestBody UserRequestDto userRequestDto) {
    	UserResponseDto reponse=user.updateData(userRequestDto);
		return reponse;
    }
    @DeleteMapping("/deleteUserById")
     public UserResponseDto deleteData(@RequestBody UserRequestDto userrequestDto) {
    	UserResponseDto response = user.delete(userrequestDto); 
    	return response;
     }
    
    
}
