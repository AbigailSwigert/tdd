package com.java;

public class ReceiptGenerator {

    public static Receipt generateReceipt(Item[] basket) {
        if(basket == null) {
            return null;
        };
        Receipt receipt = new Receipt();
        for (Item item: basket) {
            receipt.itemPricesAfterTax = receipt.itemPricesAfterTax.concat(item.quantity + " " + item.name + ": $" + calcItemPriceAfterTax(item) + "\n");
        }
        System.out.println(receipt.itemPricesAfterTax);
        receipt.totalDue = calcTotalDue(basket);
        receipt.totalTax = calcTotalTax(basket);
        System.out.println("Sales Taxes: $" + receipt.totalTax + " Total: $" + receipt.totalDue);
        return receipt;
    }

    private static double calcTotalDue(Item[] basket) {
        double totalDue = 0.0;
        for (Item item: basket) {
            totalDue += calcItemPriceAfterTax(item);
        }
        return Math.round(totalDue * 100.00) / 100.00;
    }

    private static double calcTotalTax(Item[] basket) {
        double totalTax = 0.0;
        for (Item item: basket) {
            totalTax += ((Math.round((item.price * item.taxRate) * 20.00) / 20.00) * item.quantity);
        }
        return Math.round(totalTax * 100.00) / 100.00;
    }

    private static double calcItemPriceAfterTax(Item item) {
        double itemPriceAfterTax = ((Math.round((item.price * item.taxRate) * 20.00) / 20.00) + item.price) * item.quantity;
        return Math.round(itemPriceAfterTax * 100.00) / 100.00;
    }
}
