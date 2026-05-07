package org.example;

import java.util.List;

public class App {

    public static void main(String[] args) {
        PricingEngine engine = new PricingEngine();

        double total = engine.calculate(
            List.of(100.0, 50.0, 25.0),
            List.of(2, 3, 4),
            "VIP",
            "SAVE10"
        );

        System.out.println("Total: " + total);
    }
}