package com.dariocuevas.restServer.dao;

import com.dariocuevas.restServer.model.User;

public interface UserDao {
	
	void addUser(User user);
	
	User getUserById(Long id);
	
	void saveUser(User user);
}
