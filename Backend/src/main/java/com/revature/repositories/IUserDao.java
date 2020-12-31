package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface IUserDao {
	
	public User getOneUser(String username, String password);
	
	public List<User> getAllUsers();
}
