package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class AppTest {

    // اختبار 1: زبون عادي بدون كود خصم
    @Test
    public void testRegularCustomerNoDiscount() {
        double result = App.calculate(
            List.of(100.0),
            List.of(1),
            "REGULAR",
            ""
        );
        // Subtotal=100, Discount=0, Tax=19, Total=119
        assertEquals(119.0, result, 0.001);
    }

    // اختبار 2: كود SAVE10
    @Test
    public void testSave10Discount() {
        double result = App.calculate(
            List.of(100.0),
            List.of(1),
            "REGULAR",
            "SAVE10"
        );
        // Subtotal=100, Discount=10, Tax=17.1, Total=107.1
        assertEquals(107.1, result, 0.001);
    }

    // اختبار 3: كود SAVE20
    @Test
    public void testSave20Discount() {
        double result = App.calculate(
            List.of(100.0),
            List.of(1),
            "REGULAR",
            "SAVE20"
        );
        // Subtotal=100, Discount=20, Tax=15.2, Total=95.2
        assertEquals(95.2, result, 0.001);
    }

    // اختبار 4: زبون VIP بدون كود
    @Test
    public void testVipCustomerNoDiscount() {
        double result = App.calculate(
            List.of(100.0),
            List.of(1),
            "VIP",
            ""
        );
        // Subtotal=100, Discount=5(VIP), Tax=17.85, Total=112.85
        assertEquals(113.05, result, 0.001);
    }

    // اختبار 5: زبون VIP مع SAVE10
    @Test
    public void testVipWithSave10() {
        double result = App.calculate(
            List.of(100.0),
            List.of(1),
            "VIP",
            "SAVE10"
        );
        // Subtotal=100, Discount=15(10+5), Tax=14.25, Total=99.25
        assertEquals(101.15, result, 0.001);
    }

    // اختبار 6: منتجات متعددة
    @Test
    public void testMultipleItems() {
        double result = App.calculate(
            List.of(100.0, 50.0, 25.0),
            List.of(2, 3, 4),
            "VIP",
            "SAVE10"
        );
        // Subtotal=450, Discount=67.5, Tax=72.675, Total=455.175
        assertEquals(455.175, result, 0.001);
    }
}