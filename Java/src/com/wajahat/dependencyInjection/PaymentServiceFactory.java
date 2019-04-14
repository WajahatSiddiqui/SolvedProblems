package com.wajahat.dependencyInjection;

/**
 * Payment Service Factory
 * Created by Wajahat
 **/
public class PaymentServiceFactory {
    public static PaymentService getPaymentService(String method) {
        switch (method) {
            case "cash":
                return new CashPaymentService();
            case "card":
                return new CardPaymentService();
            default:
                return null;
        }
    }
}
