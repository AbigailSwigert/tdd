package com.java;

import java.util.Arrays;

public class ReceiptGenerator {

    public static Receipt generateReceipt(Item[] basket) {
        if(basket == null) {
            return null;
        };
        Receipt receipt = new Receipt();
        receipt.totalDue = calcTotalDue(basket);
        return receipt;
    }

    private static double calcTotalDue(Item[] basket) {
        double totalDue = 0;
        for (Item item: basket) {
            totalDue += item.price;
        }
        return totalDue;
    }
}
