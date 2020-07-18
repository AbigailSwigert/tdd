package com.java;

public class Item {
    double price;
    double taxRate;
    boolean isTaxExempt;
    boolean isImported;
    String name;

    public Item(String name, double price, boolean isTaxExempt, boolean isImported) {
        this.name = name;
        this.price = price;
        this.isTaxExempt = isTaxExempt;
        if (isTaxExempt && isImported) {
            this.taxRate = 0.05;
        } else if (isTaxExempt){
            this.taxRate = 0.0;
        } else if(isImported) {
            this.taxRate = 0.15;
        } else {
            this.taxRate = 0.10;
        }
    }
}
