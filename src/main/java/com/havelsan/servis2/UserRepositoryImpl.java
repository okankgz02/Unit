package com.havelsan.servis2;

import com.havelsan.service.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl {

    private List<Kullanici> kullanicis=new ArrayList<Kullanici>();

    public UserRepositoryImpl(){
        kullanicis.add(new Kullanici("ali","veli"));

    }

    public  void ekle(Kullanici kullanici){
        kullanicis.add(kullanici);
    }

    public List<Kullanici> getKullanici(){
        return  kullanicis;
    }

}
