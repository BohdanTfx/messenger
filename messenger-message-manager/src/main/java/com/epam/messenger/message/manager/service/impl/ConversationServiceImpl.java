package com.epam.messenger.message.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.messenger.common.model.Conversation;
import com.epam.messenger.message.manager.dao.ConversationDao;
import com.epam.messenger.message.manager.service.ConversationService;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationDao conversationDao;

    @Override
    public Conversation get(Long id) {
	return conversationDao.findOne(id);
    }

}
