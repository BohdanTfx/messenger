package com.epam.mentorship.user.service.service;

import com.epam.messenger.common.model.User;

public interface UserService {
	User get(Long id);

	User save(User user);
}
