package com.cts.bloggingwebsite.dao;

import java.util.List;

import com.cts.bloggingwebsite.entities.User;

public interface  UserDao { 
	
	public boolean login(String email, String password);
	public boolean addUser(User user);
	public User getUserById(int user_id);
	public List<User> getAllUsers();
	public boolean updateUserById(User user);
	public boolean deleteUserById(int user_id);
	public boolean deleteAllUser();
	
	
	
}
