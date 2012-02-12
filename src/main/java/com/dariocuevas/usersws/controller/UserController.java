package com.dariocuevas.usersws.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.dariocuevas.usersws.model.User;
import com.dariocuevas.usersws.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	@Inject
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET,
					headers = {"Accept=text/xml, application/json"})
	public @ResponseBody User getUser(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
					headers = "Content-Type=application/xml")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody User createUser(@RequestBody User user,
			HttpServletResponse response) {

		userService.saveUser(user);
	    response.setHeader("Location", "/users/" + user.getId());
	    return user;
	}
	
}
