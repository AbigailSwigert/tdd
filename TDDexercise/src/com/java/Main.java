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
        Item importedBottleOfPerfume1 = new Item(1, "imported bottle of perfume", 47.50, false, true);

        Item[] basket2 = new Item[]{importedBoxOfChocolates1, importedBottleOfPerfume1};

        ReceiptGenerator.generateReceipt(basket2);

        // Input 3:
        Item importedBottleOfPerfume2 = new Item(1, "imported bottle of perfume", 27.99, false, true);
        Item bottleOfPerfume = new Item(1, "bottle of perfume", 18.99, false, false);
        Item packetOfHeadachePills = new Item(1, "packet of headache pills", 9.75, true, false);
        Item importedBoxOfChocolates2 = new Item(1, "imported box of chocolates", 11.25, true, true);

        Item[] basket3 = new Item[]{importedBottleOfPerfume2, bottleOfPerfume, packetOfHeadachePills, importedBoxOfChocolates2};

        ReceiptGenerator.generateReceipt(basket3);
    }
}
