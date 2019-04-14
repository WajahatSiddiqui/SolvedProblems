package com.wajahat.dependencyInjection;

import java.util.ArrayList;
import java.util.List;

/**
 * Shopping Cart
 * Created by Wajahat
 **/
public class Cart {
    private PaymentService paymentService;
    List<Product> productList = new ArrayList<>();

    public Cart(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void checkout() {
        paymentService.pay(productList.stream()
                .mapToDouble(product -> (product.getPrice()*product.getQuantity())).sum());
    }


}
