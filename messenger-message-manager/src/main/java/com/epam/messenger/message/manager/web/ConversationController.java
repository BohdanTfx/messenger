package com.epam.messenger.message.manager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.messenger.common.dto.ConversationDTO;
import com.epam.messenger.common.model.Conversation;
import com.epam.messenger.common.util.ModelTransformer;
import com.epam.messenger.message.manager.service.ConversationService;

@RestController
@RequestMapping("conv")
public class ConversationController {

  @Autowired
  private ConversationService conversationService;

  @GetMapping("/{id}")
  public Conversation getConversation(@PathVariable Long id) {
    Conversation conversation = conversationService.get(id);
    conversation.setMessages(conversationService.findMessages(id));
    return conversation;
  }

  @PostMapping
  public Conversation create(@RequestBody ConversationDTO dto) {
    Conversation conversation = ModelTransformer.toConversation(dto);
    return conversationService.create(conversation);
  }
}
