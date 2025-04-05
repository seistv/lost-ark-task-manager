package com.seistv.lostarktaskmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seistv.lostarktaskmanager.model.User;
import com.seistv.lostarktaskmanager.repository.UserRepository;
import com.seistv.lostarktaskmanager.service.UserService;

@Service
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