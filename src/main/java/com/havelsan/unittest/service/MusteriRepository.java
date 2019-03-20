package com.havelsan.unittest.service;

public class MusteriRepository {

    public void kaydet(Musteri musteri) {
        System.out.println("kaydedildi");
    }

    public  void sil(Integer musteriId)
    {
        System.out.println("Müsteri silindi");
    }
    public  Musteri bul(Integer musteriId)
    {
        System.out.println("oracle db bul");
        return null;
    }

}
