package com.java;

public class Main {

    public static void main(String[] args) {
        // Input 1:
        Item book = new Item(1, "book", 12.49, true, false);
        Item musicCD = new Item(1, "music CD", 14.99, false, false);
        Item chocolateBar = new Item(1, "chocolate bar", 0.85, true, false);

        Item[] basket1 = new Item[]{book, musicCD, chocolateBar};

        ReceiptGenerator.generateReceipt(basket1);

        // Input 2:
        Item importedBoxOfChocolates1 = new Item(1, "imported box of chocolates", 10.00, true, true);
        Item importedBottleOfPerfume = new Item(1, "imported bottle of perfume", 47.50, false, true);

        Item[] basket2 = new Item[]{importedBoxOfChocolates1, importedBottleOfPerfume};

        ReceiptGenerator.generateReceipt(basket2);
    }
}
