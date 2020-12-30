package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Credentials;
import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDao implements IUserDao {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	public User getOneUser(String username, String password) {
		Connection conn = this.cf.getConnection();
		User user = null;
		Credentials creds = null;
		try {

			String sql = "select * from users where \"username\" = ? and \"password\" = ?;";
			PreparedStatement findUser = conn.prepareStatement(sql);

			findUser.setString(1, username);
			findUser.setString(2, password);

			ResultSet res = findUser.executeQuery();

			if (res.next()) {
				user = new User();
				creds = new Credentials();
				creds.setUsername(res.getString("username"));
				creds.setPassword(res.getString("password"));
				user.setCreds(creds);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Employee getOneEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	public Manager getOneManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		Connection conn = this.cf.getConnection();
		List<User> allUsers = new ArrayList<User>();

		try {
			String sql = "select * from users";
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);

			while (res.next()) {
				User user = new User();
				Credentials creds = new Credentials();
				creds.setUsername(res.getString("username"));
				creds.setPassword(res.getString("password"));
				user.setCreds(creds);
				allUsers.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allUsers;
	}
	
	
}
