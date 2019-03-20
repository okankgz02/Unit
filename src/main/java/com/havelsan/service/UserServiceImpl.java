package com.havelsan.service;

import java.util.List;

public class UserServiceImpl {

  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getUsers() {
    List<User> userList = userRepository.getUsers();
    return userList;
  }
}
