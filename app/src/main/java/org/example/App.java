package org.example;

import java.util.List;

public class App {

    public static double calculate(List<Double> prices,
                                   List<Integer> quantities,
                                   String customerType,
                                   String discountCode) {
        double subtotal = 0;
        for (int i = 0; i < prices.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }

        double discount = 0;
        if (discountCode.equals("SAVE10")) {
            discount = subtotal * 0.10;
        } else if (discountCode.equals("SAVE20")) {
            discount = subtotal * 0.20;
        } else if (discountCode.equals("SAVE5")) {
            discount = subtotal * 0.05;
        }

        if (customerType.equals("VIP")) {
            discount += subtotal * 0.05;
        }

        double afterDiscount = subtotal - discount;
        double tax = afterDiscount * 0.19;
        double total = afterDiscount + tax;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Total: " + total);

        return total;
    }

    public static void main(String[] args) {
        calculate(
            List.of(100.0, 50.0, 25.0),
            List.of(2, 3, 4),
            "VIP",
            "SAVE10"
        );
    }
}