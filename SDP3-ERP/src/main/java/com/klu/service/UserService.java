package com.klu.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.klu.model.User;
import com.klu.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
