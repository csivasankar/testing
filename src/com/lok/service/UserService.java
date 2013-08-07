package com.lok.service;

import com.lok.model.User;

public interface UserService {

	public abstract User saveUser(User user);
	
	public abstract void deleteUser(User user);
	
	public abstract User updateUser(User user);
	
	public abstract User getUser(long userId);
	
	public abstract long getUserId(User user);
	
	public abstract long getUserCount();
}
