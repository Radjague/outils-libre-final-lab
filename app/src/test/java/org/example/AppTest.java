package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class AppTest {

    private final PricingEngine engine = new PricingEngine();

    @Test
    public void testRegularCustomerNoDiscount() {
        double result = engine.calculate(
            List.of(100.0), List.of(1), "REGULAR", "");
        assertEquals(119.0, result, 0.001);
    }

    @Test
    public void testSave10Discount() {
        double result = engine.calculate(
            List.of(100.0), List.of(1), "REGULAR", "SAVE10");
        assertEquals(107.1, result, 0.001);
    }

    @Test
    public void testSave20Discount() {
        double result = engine.calculate(
            List.of(100.0), List.of(1), "REGULAR", "SAVE20");
        assertEquals(95.2, result, 0.001);
    }

    @Test
    public void testVipCustomerNoDiscount() {
        double result = engine.calculate(
            List.of(100.0), List.of(1), "VIP", "");
        assertEquals(113.05, result, 0.001);
    }

    @Test
    public void testVipWithSave10() {
        double result = engine.calculate(
            List.of(100.0), List.of(1), "VIP", "SAVE10");
        assertEquals(101.15, result, 0.001);
    }

    @Test
    public void testMultipleItems() {
        double result = engine.calculate(
            List.of(100.0, 50.0, 25.0), List.of(2, 3, 4), "VIP", "SAVE10");
        assertEquals(455.175, result, 0.001);
    }
}