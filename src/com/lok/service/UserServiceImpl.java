package com.lok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lok.dao.UserDao;
import com.lok.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.update(user);
	}

	@Override
	public User getUser(long userId) {
		return userDao.getUser(userId);
	}

	@Override
	public long getUserId(User user) {
		return userDao.getUserId(user);
	}

	@Override
	public long getUserCount() {
		return userDao.getUserCount();
	}

}
