package com.wajahat.dependencyInjection;

/**
 * Shopping Cart Application
 * Created by Wajahat
 **/
public class ShoppingCartApp {

    public static void main(String args[]) {
        Cart cart = new Cart(PaymentServiceFactory.getPaymentService("card"));
        cart.addProduct(new Product("P001", "Samsung Galaxy S10", 1, 60000.0));
        cart.addProduct(new Product("P001", "Samsung Galaxy S10 Cover", 1, 600.0));
        cart.checkout();
    }
}
