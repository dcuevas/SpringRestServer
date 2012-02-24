package com.dariocuevas.restServer.service;

import com.dariocuevas.restServer.model.User;

public interface UserService {
	
	User getUser(Long id);
	
	void saveUser(User user);
	
	void updateUser(User user);

}
