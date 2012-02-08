package com.dariocuevas.usersws.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dariocuevas.usersws.dao.UserDao;
import com.dariocuevas.usersws.model.User;

@Service
public class DefaultUserService implements UserService {
	
	private UserDao userDao;
	
	@Inject
	public DefaultUserService(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUser(final Long id) {
		return userDao.getUserById(id);
	}

	@Override
	public void saveUser(final User user) {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.saveUser(user);
	}

}
