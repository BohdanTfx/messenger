package com.epam.messenger.user.management.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.messenger.common.dto.UserDTO;
import com.epam.messenger.common.model.User;
import com.epam.messenger.common.util.UserTransformer;
import com.epam.messenger.user.management.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User readMessage(@PathVariable Long id) {
    return userService.get(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public User saveMessage(@RequestBody UserDTO messageDTO) {
    return userService.save(UserTransformer.toUser(messageDTO));
  }
}
