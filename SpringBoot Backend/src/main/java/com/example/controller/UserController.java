package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(
			value = "userLoggedIn",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void userLoggedIn(@RequestBody HashMap<String,String> user)
	{
		
		if(userService.findOneAuthId(user.get("auth_id")) == null)
		{
			User u = new User();
			u.setAuth_id(user.get("auth_id"));
			u.setFirstName(user.get("firstname"));
			u.setLastName(user.get("lastname"));
			u.setUsername(user.get("username"));
			u.setEmail(user.get("email"));
			
			u.setAddress("address");
			u.setPhone("phone");
			
			userService.create(u);
		}

	}
}
