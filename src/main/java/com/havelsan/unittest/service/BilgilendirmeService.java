package com.havelsan.unittest.service;

import com.havelsan.exception.MailServerUnavailableException;

public class BilgilendirmeService {

    public void yeniKayitMailGonder(Musteri musteri) {
        System.out.println("mail gönderildi");
    }

    public void haftalikMailGonder() {
        throw new MailServerUnavailableException("mail server exception");
    }
}
