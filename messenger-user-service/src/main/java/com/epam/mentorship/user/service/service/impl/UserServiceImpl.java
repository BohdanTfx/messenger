package com.epam.mentorship.user.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentorship.common.model.User;
import com.epam.mentorship.user.service.dao.UserDao;
import com.epam.mentorship.user.service.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User get(Long id) {
		return userDao.getOne(id);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

}
