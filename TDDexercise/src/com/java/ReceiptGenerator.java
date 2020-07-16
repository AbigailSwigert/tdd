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
        double totalOfItems = 0.0;
        for (Item item: basket) {
            totalOfItems += (item.price);
        }
        return totalOfItems + calcTotalTax(basket);
    }

    private static double calcTotalTax(Item[] basket) {
        double totalTax = 0.0;
        for (Item item: basket) {
            totalTax += (item.price * item.taxRate);
        }
        return totalTax;
    }
}
