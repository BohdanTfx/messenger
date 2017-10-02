package com.epam.messenger.message.manager.service;

import com.epam.messenger.common.model.Message;

public interface MessageService {
  Message read(Long id);

  Message save(Message message);
}
