package org.example;

public class DiscountService {

    public double getDiscount(double subtotal,
                              String customerType,
                              String discountCode) {
        double discount = 0;

        switch (discountCode) {
            case "SAVE10": discount += subtotal * 0.10; break;
            case "SAVE20": discount += subtotal * 0.20; break;
            case "SAVE5":  discount += subtotal * 0.05; break;
        }

        if ("VIP".equals(customerType)) {
            discount += subtotal * 0.05;
        }

        return discount;
    }
}