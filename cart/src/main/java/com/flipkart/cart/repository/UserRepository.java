package com.flipkart.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkart.cart.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>  {

} 


