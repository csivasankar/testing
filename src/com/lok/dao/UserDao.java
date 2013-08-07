package com.lok.dao;

import com.lok.model.User;

public interface UserDao {

	public abstract User save(User user);
	
	public abstract void delete(User user);
	
	public abstract User update(User user);
	
	public abstract User getUser(long userId);
	
	public abstract long getUserId(User user);
	
	public abstract long getUserCount();
}
