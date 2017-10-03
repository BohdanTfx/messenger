package com.epam.messenger.common.util;

import com.epam.messenger.common.dto.UserDTO;
import com.epam.messenger.common.model.User;

public class UserTransformer {

  public static User toUser(UserDTO userDTO) {
    User user = new User();
    user.setId(userDTO.getId());
    user.setFirstName(userDTO.getFirstName());
    user.setLastName(userDTO.getLastName());
    return user;
  }

}
