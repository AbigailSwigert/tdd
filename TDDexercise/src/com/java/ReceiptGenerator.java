package com.java;

import java.util.Arrays;

public class ReceiptGenerator {

    public static Receipt generateReceipt(Item[] basket) {
        if(basket == null) {
            return null;
        };
        Receipt receipt = new Receipt();
        receipt.totalDue = calcTotalDue(basket);
        receipt.totalTax = calcTotalTax(basket);
        return receipt;
    }

    private static double calcTotalDue(Item[] basket) {
        double totalDue = 0.0;
        for (Item item: basket) {
            totalDue += (Math.round((item.price * item.taxRate) * 20.00) / 20.00) + item.price;
        }
        return Math.round(totalDue * 100.00) / 100.00;
    }

    private static double calcTotalTax(Item[] basket) {
        double totalTax = 0.0;
        for (Item item: basket) {
            totalTax += (Math.round((item.price * item.taxRate) * 20.00) / 20.00);
        }
        return Math.round(totalTax * 100.00) / 100.00;
    }
}
