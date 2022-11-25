package com.dev.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.jpa.dto.UserRequest;
import com.dev.jpa.dto.UserResponse;
import com.dev.jpa.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	@PostMapping("/signup")
	public UserResponse saveUser(@RequestBody UserRequest paylaod ) {
		log.info(this.getClass().getName()+"Save User payload :: {} ",paylaod);
		return userService.saveUser(paylaod);
		
	}
	
	@PutMapping("/{userId}")
	public UserResponse saveUser(@PathVariable("userId") final Integer userId,@RequestBody UserRequest paylaod ) {
		log.info(this.getClass().getName()+"Update  User payload :: {} ",paylaod);
		
		return userService.updateUser(userId,paylaod);
		
	}
	
}
