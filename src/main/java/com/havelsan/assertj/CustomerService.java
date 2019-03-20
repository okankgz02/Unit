package com.havelsan.assertj;

import lombok.Setter;

@Setter
public class CustomerService {

    private CustomerRepository customerRepository;

    private NotificationService notificationService;


    public  Customer handleNewCustomer(String customerName,String email){

        Customer customer=new Customer(customerName,email);

        giveWelcomeGifts(customer); //liste 2 hediye eklendi
        customerRepository.save(customer);
        notificationService.sendWelcomeNotification(customerName,email);

        return customer;

    }

    private void giveWelcomeGifts(Customer customer) {
        customer.addGift(new Gift("welcome1"));
        customer.addGift(new Gift("welcome2"));
    }
}
