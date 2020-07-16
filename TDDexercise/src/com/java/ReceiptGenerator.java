package com.java;

public class ReceiptGenerator {

    public static Receipt generateReceipt(Item[] basket) {
        if(basket == null) {
            return null;
        };
        return new Receipt();
    }
}
