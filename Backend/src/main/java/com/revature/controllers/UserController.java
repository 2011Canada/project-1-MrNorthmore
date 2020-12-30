package com.revature.controllers;

import com.revature.repositories.UserDao;
import com.revature.services.UserService;

public class UserController {
	
	private UserDao ud = new UserDao();
	
	private UserService us = new UserService(ud);
}
