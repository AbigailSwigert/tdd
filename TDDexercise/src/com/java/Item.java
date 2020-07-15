package com.java;

public class Item {
    String name;
    double price;
    int quantity;
    boolean basicSalesTaxIsApplicable;
    boolean importedGoodsSalesTaxIsApplicable;

    public Item(String name, double price, int quantity, boolean basicSalesTaxIsApplicable,
                boolean importedGoodsSalesTaxIsApplicable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.basicSalesTaxIsApplicable = basicSalesTaxIsApplicable;
        this.importedGoodsSalesTaxIsApplicable = importedGoodsSalesTaxIsApplicable;
    }
}
