package com.java;

public class Main {

    public static void main(String[] args) {
        // Input 1:
        Item book = new Item(1, "book", 12.49, true, false);
        Item musicCD = new Item(1, "music CD", 14.99, false, false);
        Item chocolateBar = new Item(1, "chocolate bar", 0.85, true, false);

        Item[] basket1 = new Item[]{book, musicCD, chocolateBar};

        ReceiptGenerator.generateReceipt(basket1);
    }
}
