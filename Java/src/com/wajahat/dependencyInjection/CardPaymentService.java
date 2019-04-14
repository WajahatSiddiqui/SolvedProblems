package com.wajahat.dependencyInjection;

/**
 * Card Payment Service
 * Created by Wajahat
 **/
public class CardPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println(amount + " Paid using card");
    }
}
