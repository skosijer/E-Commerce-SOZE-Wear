package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;
import com.example.service.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findOne(id);
	}

	@Override
	public User findOneAuthId(String id) {
		// TODO Auto-generated method stub
		return userRepo.findByAuthId(id);
	}
}
