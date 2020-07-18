package com.java;

public class Main {

    public static void main(String[] args) {

        Item taxableImportedItem1 = new Item(1.00, false, true);
        Item taxableImportedItem2 = new Item(1.50, false, true);
        Item taxableImportedItem3 = new Item(1.25, false, true);
        Item[] basket = new Item[]{taxableImportedItem1, taxableImportedItem2, taxableImportedItem3};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);
    }
}
