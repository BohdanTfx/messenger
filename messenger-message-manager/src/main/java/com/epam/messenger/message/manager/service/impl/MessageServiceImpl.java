package com.epam.messenger.message.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.messenger.common.model.Message;
import com.epam.messenger.message.manager.dao.MessageDao;
import com.epam.messenger.message.manager.dao.SequenceDao;
import com.epam.messenger.message.manager.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;
	@Autowired
	private SequenceDao sequenceDao;

	@Override
	public Message read(Long id) {
		return messageDao.findOne(id);
	}

	@Override
	public Message save(Message message) {
		if (message.getId() == null) {
			message.setId(sequenceDao.getNextSequenceId());
		}
		return messageDao.save(message);
	}

}
