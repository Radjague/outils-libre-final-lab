package org.example;

public class TaxService {

    private static final double TAX_RATE = 0.19;

    public double getTax(double amountAfterDiscount) {
        return amountAfterDiscount * TAX_RATE;
    }
}