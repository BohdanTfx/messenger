package com.epam.messenger.message.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.messenger.common.model.Conversation;
import com.epam.messenger.common.model.Message;
import com.epam.messenger.message.manager.dao.ConversationDao;
import com.epam.messenger.message.manager.dao.MessageDao;
import com.epam.messenger.message.manager.dao.SequenceDao;
import com.epam.messenger.message.manager.service.ConversationService;

@Service
public class ConversationServiceImpl implements ConversationService {

  @Autowired
  private ConversationDao conversationDao;
  @Autowired
  private MessageDao messageDao;
  @Autowired
  private SequenceDao sequenceDao;

  @Override
  public Conversation get(Long id) {
    return conversationDao.findOne(id);
  }

  @Override
  public Conversation create(Conversation conversation) {
    Date now = new Date();
    if (conversation.getId() == null) {
      conversation.setId(sequenceDao.getNextSequenceId());
      conversation.setCreateDate(now);
    }
    conversation.setUpdateDate(now);
    return conversationDao.save(conversation);
  }

  @Override
  public List<Message> findMessages(Long id) {
    return messageDao.findByConversation(id);
  }

}
