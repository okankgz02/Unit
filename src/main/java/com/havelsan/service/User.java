package com.havelsan.service;

public class User {

    private String username;
    private String surname;


    public User(String username, String surname) {
        this.username = username;
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
