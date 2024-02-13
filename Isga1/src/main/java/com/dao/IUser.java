package com.dao;

import java.util.List;

import com.model.User;

public interface IUser {

	public int adduser(User u);
	public int adduser(String lg,String ps);
	public User findById(int id);
	List<User> allUsers();
}
