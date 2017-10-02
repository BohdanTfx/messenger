package com.epam.messenger.message.manager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.messenger.common.dto.MessageDTO;
import com.epam.messenger.common.model.Message;
import com.epam.messenger.common.util.MessageTransformer;
import com.epam.messenger.message.manager.service.MessageService;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Message readMessage(@PathVariable Long id) {
	return messageService.read(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Message saveMessage(@RequestBody MessageDTO messageDTO) {
	return messageService.save(MessageTransformer.toMessage(messageDTO));
    }
}
