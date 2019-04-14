package com.wajahat.dependencyInjection;

/**
 * Cash Payment Service
 * Created by Wajahat
 **/
public class CashPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println(amount + " Paid using cash");
    }
}
