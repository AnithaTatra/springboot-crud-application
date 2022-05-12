package com.flipkart.cart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.cart.constants.ConstantsStatus;
import com.flipkart.cart.entity.UserEntity;
import com.flipkart.cart.model.UserRequestDto;
import com.flipkart.cart.model.UserResponseDto;
import com.flipkart.cart.repository.UserRepository;
import com.flipkart.cart.service.UserData;

@Service
public class UserDataImpl implements UserData {

	@Autowired
	UserRepository userrepository;

	@Override
	public UserResponseDto userDetails(UserRequestDto userrequestDto) {
		UserEntity userentity = new UserEntity();
		UserResponseDto userResponseDto = new UserResponseDto();
		userentity.setUserName(userrequestDto.getUserName());
		userentity.setPassWord(userrequestDto.getPassWord());
		userentity.setEmailId(userrequestDto.getEmailId());
		userrepository.saveAndFlush(userentity);
		userResponseDto.setStatus("successfully Inserted");
		return userResponseDto;
	}

	@Override
	public List<UserEntity> getUserData() {
		List<UserEntity> userentity = userrepository.findAll();
		return userentity;
	}

	@Override
	public UserResponseDto updateData(UserRequestDto userrequestDto) {
		UserResponseDto userreponse = new UserResponseDto();
		try {
			UserEntity userentity = new UserEntity();
			userentity = userrepository.getOne(userrequestDto.getId());
			if (userentity != null) {
				userentity.setUserName(userrequestDto.getUserName());
				userentity.setPassWord(userrequestDto.getPassWord());
				userentity.setEmailId(userrequestDto.getEmailId());
				if (null != userrepository.saveAndFlush(userentity)) {
					userreponse.setStatus(ConstantsStatus.SUCCESS);
				} else {
					userreponse.setStatus(ConstantsStatus.FAILURE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userreponse;
	}

	@Override
	public UserResponseDto delete(UserRequestDto userrequestDto) {
		UserResponseDto userresponsse = new UserResponseDto();

		try {
			userrepository.deleteById(userrequestDto.getId());
			userresponsse.setStatus(ConstantsStatus.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userresponsse;
	}
}
