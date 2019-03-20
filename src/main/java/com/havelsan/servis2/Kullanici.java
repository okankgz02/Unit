package com.havelsan.servis2;

import lombok.Data;

@Data
public class Kullanici {

    private String name;
    private String lastname;

    public Kullanici(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
}
