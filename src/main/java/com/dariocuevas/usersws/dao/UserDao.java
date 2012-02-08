package com.dariocuevas.usersws.dao;

import com.dariocuevas.usersws.model.User;

public interface UserDao {
	
	void addUser(User user);
	
	User getUserById(Long id);
	
	void saveUser(User user);
}
