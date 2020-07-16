package com.java;

public class Item {
    double price;
    double taxRate;
    boolean isTaxExempt;

    public Item(double price, boolean isTaxExempt) {
        this.price = price;
        this.isTaxExempt = isTaxExempt;
        if (isTaxExempt) {
            this.taxRate = 0;
        } else {
            this.taxRate = 1.10;
        }
    }
}
