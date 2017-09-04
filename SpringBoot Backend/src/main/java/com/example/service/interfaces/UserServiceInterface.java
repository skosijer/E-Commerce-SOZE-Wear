package com.example.service.interfaces;

import com.example.domain.User;

public interface UserServiceInterface {
	
	User create(User user);
	User findOne(Long id);
	User findOneAuthId(String id);
}
