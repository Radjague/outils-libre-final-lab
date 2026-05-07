package org.example;

import java.util.List;

public class PricingEngine {

    private final DiscountService discountService;
    private final TaxService taxService;

    public PricingEngine() {
        this.discountService = new DiscountService();
        this.taxService = new TaxService();
    }

    public double calculate(List<Double> prices,
                            List<Integer> quantities,
                            String customerType,
                            String discountCode) {

        double subtotal = computeSubtotal(prices, quantities);
        double discount = discountService.getDiscount(subtotal, customerType, discountCode);
        double afterDiscount = subtotal - discount;
        double tax = taxService.getTax(afterDiscount);

        return afterDiscount + tax;
    }

    private double computeSubtotal(List<Double> prices, List<Integer> quantities) {
        double subtotal = 0;
        for (int i = 0; i < prices.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }
        return subtotal;
    }
}