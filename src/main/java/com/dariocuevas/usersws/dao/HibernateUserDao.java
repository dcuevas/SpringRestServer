package com.dariocuevas.usersws.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dariocuevas.usersws.model.User;

@Repository
public class HibernateUserDao implements UserDao {
	
	private SessionFactory sessionFactory;
	
	@Inject  
	public HibernateUserDao(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	
	}
	
	private Session currentSession() {
	    return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addUser(final User user) {
		currentSession().save(user);
	}

	@Override
	public User getUserById(final Long id) {
		return (User) currentSession().get(User.class, id);
	}

	@Override
	public void saveUser(final User user) {
		currentSession().update(user);
	}

}
