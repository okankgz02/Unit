package com.havelsan.servis2;

import com.havelsan.service.UserRepository;
import com.havelsan.service.UserServiceImpl;

import java.util.List;

public class UserServisImpl {
    private UserRepositoryImpl userRepositoryImpl;

    Kullanici kullanici=new Kullanici("okan","akgöz");


    public UserServisImpl(UserRepositoryImpl userRepositoryImpl){
        this.userRepositoryImpl=userRepositoryImpl;
    }

    public void ekle(){
        userRepositoryImpl.ekle(kullanici);
    }

    public List<Kullanici> kullaniciGet(){

        return userRepositoryImpl.getKullanici();
    }


}
