package com.epam.messenger.user.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.messenger.common.model.User;
import com.epam.messenger.user.management.dao.UserDao;
import com.epam.messenger.user.management.service.UserService;

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
