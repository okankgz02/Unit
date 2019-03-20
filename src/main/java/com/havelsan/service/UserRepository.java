package com.havelsan.service;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users= new ArrayList<User>();

    public UserRepository(){
        users.add(new User("usernameTest","surnameTest"));
    }

    public List<User> getUsers(){
        return users;
    }
}
