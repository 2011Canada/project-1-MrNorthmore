package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UserDao;

public class UserService implements IUserService {
	
	private UserDao ud;
	
	public UserService(UserDao ud) {
		this.ud = ud;
	}
	
	
	
	@Override
	public User login(String username, String password) {
			User u = ud.getOneUser(username, password);
			return u;
	}



	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return ud.getAllUsers();
	}
	
}
