package com.flipkart.cart.service;

import java.util.List;

import com.flipkart.cart.entity.UserEntity;
import com.flipkart.cart.model.UserRequestDto;
import com.flipkart.cart.model.UserResponseDto;

public interface UserData {

	public UserResponseDto userDetails(UserRequestDto userrequestDto);
	
	public List<UserEntity> getUserData();
	
	public UserResponseDto updateData(UserRequestDto userrequestDto);
	
	public UserResponseDto delete(UserRequestDto userrequestDto);
 
}
