package com.seistv.lostarktaskmanager.service.impl;

import java.util.List;

import com.seistv.lostarktaskmanager.model.User;
import com.seistv.lostarktaskmanager.repository.UserRepository;
import com.seistv.lostarktaskmanager.service.UserService;

public class UserServiceImpl implements UserService {
	
    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}