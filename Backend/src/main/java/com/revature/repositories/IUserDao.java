package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.User;

public interface IUserDao {
	
	public User getOneUser(String username, String password);

	public Employee getOneEmployee();
	
	public Manager getOneManager();
	
	public List<User> getAllUsers();
}
