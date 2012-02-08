package com.dariocuevas.usersws.service;

import com.dariocuevas.usersws.model.User;

public interface UserService {
	
	User getUser(Long id);
	
	void saveUser(User user);
	
	void updateUser(User user);

}
