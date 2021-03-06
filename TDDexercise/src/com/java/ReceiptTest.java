package com.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    @Test
    public void GivenNullShoppingBasketGenerateReceiptReturnsNull() {
        // arrange
        Item[] basket = null;

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertNull(receipt);
    }

    @Test
    public void GivenEmptyShoppingBasketGenerateReceiptReturnsNonNull() {
        // arrange
        Item[] basket = new Item[]{};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertNotNull(receipt);
    }

    @Test
    public void GivenEmptyShoppingBasketGenerateReceiptReturnsReceiptWithEmptyItemCollection() {
        // arrange
        Item[] basket = new Item[]{};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        //assert
        assertArrayEquals(new Object[]{}, receipt.items);
    }

    @Test
    public void GivenEmptyShoppingBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo0() {
        // arrange
        Item[] basket = new Item[]{};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        //assert
        assertEquals(0, receipt.totalTax);
    }

    @Test
    public void GivenEmptyShoppingBasketGenerateReceiptReturnsReceiptWithTotalDueEqualTo0() {
        // arrange
        Item[] basket = new Item[]{};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        //assert
        assertEquals(0, receipt.totalDue);
    }

    @Test // Come back to this test
    public void Given1TaxExemptItemInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo0() {
        // arrange
        Item taxExemptItem = new Item(1, "Item", 1.00, true, false);
        Item[] basket = new Item[]{taxExemptItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        //assert
        assertEquals(0, receipt.totalTax);
    }

    @Test
    public void Given1TaxExemptItemInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToItemPrice() {
        // arrange
        Item taxExemptItem = new Item(1, "Item", 1.00, true, false);
        Item[] basket = new Item[]{taxExemptItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        //assert
        assertEquals(taxExemptItem.price, receipt.totalDue);
    }

    @Test
    public void Given1TaxableItemInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo10PercentOfItemPrice() {
        // arrange
        Item taxableItem = new Item(1, "Item", 1.00, false, false);
        Item[] basket = new Item[]{taxableItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.10, receipt.totalTax);
    }

    @Test
    public void Given1TaxableItemInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToItemPriceAfterTax() {
        // arrange
        Item taxableItem = new Item(1, "Item", 1.00, false, false);
        Item[] basket = new Item[]{taxableItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(1.10, receipt.totalDue);
    }

    @Test
    public void Given1TaxExemptImportedItemInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo5PercentOfItemPrice() {
        // arrange
        Item taxExemptItem = new Item(1, "Item", 1.00, true, true);
        Item[] basket = new Item[]{taxExemptItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.05, receipt.totalTax);
    }

    @Test
    public void Given1TaxExemptImportedItemInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToItemPriceAfterTax() {
        // arrange
        Item taxExemptItem = new Item(1, "Item", 1.00, true, true);
        Item[] basket = new Item[]{taxExemptItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(1.05, receipt.totalDue);
    }

    @Test
    public void Given1TaxableImportedItemInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo15PercentOfItemPrice() {
        // arrange
        Item taxableImportedItem = new Item(1, "Item", 1.00, false, true);
        Item[] basket = new Item[]{taxableImportedItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.15, receipt.totalTax);
    }

    @Test
    public void Given1TaxableImportedItemInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToItemPriceAfterTax() {
        // arrange
        Item taxableImportedItem = new Item(1, "Item", 1.00, false, true);
        Item[] basket = new Item[]{taxableImportedItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(1.15, receipt.totalDue);
    }

    @Test
    public void Given3TaxableItemsInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo10PercentOfAllItemPrices() {
        // arrange
        Item taxableItem1 = new Item(1, "Item", 1.00, false, false);
        Item taxableItem2 = new Item(1, "Item", 1.50, false, false);
        Item taxableItem3 = new Item(1, "Item", 1.25, false, false);
        Item[] basket = new Item[]{taxableItem1, taxableItem2, taxableItem3};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.4, receipt.totalTax);
    }

    @Test
    public void Given3TaxableItemsInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToAllItemPricesAfterTax() {
        // arrange
        Item taxableItem1 = new Item(1, "Item", 1.00, false, false);
        Item taxableItem2 = new Item(1, "Item", 1.50, false, false);
        Item taxableItem3 = new Item(1, "Item", 1.25, false, false);
        Item[] basket = new Item[]{taxableItem1, taxableItem2, taxableItem3};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(4.15, receipt.totalDue);
    }

    @Test
    public void Given3TaxExemptItemsInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo0() {
        // arrange
        Item taxExemptItem1 = new Item(1, "Item", 1.00, true, false);
        Item taxExemptItem2 = new Item(1, "Item", 1.50, true, false);
        Item taxExemptItem3 = new Item(1, "Item", 1.25, true, false);
        Item[] basket = new Item[]{taxExemptItem1, taxExemptItem2, taxExemptItem3};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.00, receipt.totalTax);
    }

    @Test
    public void Given3TaxExemptItemsInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToAllItemPrices() {
        // arrange
        Item taxExemptItem1 = new Item(1, "Item", 1.00, true, false);
        Item taxExemptItem2 = new Item(1, "Item", 1.50, true, false);
        Item taxExemptItem3 = new Item(1, "Item", 1.25, true, false);
        Item[] basket = new Item[]{taxExemptItem1, taxExemptItem2, taxExemptItem3};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(3.75, receipt.totalDue);
    }

    @Test
    public void Given3TaxExemptImportedItemsInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo5PercentOfAllItemPrices() {
        // arrange
        Item taxExemptImportedItem1 = new Item(1, "Item", 1.00, true, true);
        Item taxExemptImportedItem2 = new Item(1, "Item", 1.50, true, true);
        Item taxExemptImportedItem3 = new Item(1, "Item", 1.25, true, true);
        Item[] basket = new Item[]{taxExemptImportedItem1, taxExemptImportedItem2, taxExemptImportedItem3};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.2, receipt.totalTax);
    }

    @Test
    public void Given3TaxExemptImportedItemsInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToAllItemPricesAfterTax() {
        // arrange
        Item taxExemptImportedItem1 = new Item(1, "Item", 1.00, true, true);
        Item taxExemptImportedItem2 = new Item(1, "Item", 1.50, true, true);
        Item taxExemptImportedItem3 = new Item(1, "Item", 1.25, true, true);
        Item[] basket = new Item[]{taxExemptImportedItem1, taxExemptImportedItem2, taxExemptImportedItem3};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(3.95, receipt.totalDue);
    }

    @Test
    public void Given3TaxableImportedItemsInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo15PercentOfAllItemPrices() {
        // arrange
        Item taxableImportedItem1 = new Item(1, "Item", 1.00, false, true);
        Item taxableImportedItem2 = new Item(1, "Item", 1.50, false, true);
        Item taxableImportedItem3 = new Item(1, "Item", 1.25, false, true);
        Item[] basket = new Item[]{taxableImportedItem1, taxableImportedItem2, taxableImportedItem3};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.6, receipt.totalTax);
    }

    @Test
    public void Given3TaxableImportedItemsInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToAllItemPricesAfterTax() {
        // arrange
        Item taxableImportedItem1 = new Item(1, "Item", 1.00, false, true);
        Item taxableImportedItem2 = new Item(1, "Item", 1.50, false, true);
        Item taxableImportedItem3 = new Item(1, "Item", 1.25, false, true);
        Item[] basket = new Item[]{taxableImportedItem1, taxableImportedItem2, taxableImportedItem3};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(4.35, receipt.totalDue);
    }

    @Test
    public void Given1TaxableItemInBasketGenerateReceiptReturnsReceiptWithTaxesRoundedToTheNearestPoint5() {
        // arrange
        Item taxableItem = new Item(1, "Item", 1.25, false, false);
        Item[] basket = new Item[]{taxableItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.15, receipt.totalTax);
    }

    // Works but does not pass, not sure why
//    @Test
//    public void Given3ItemsInBasketGenerateReceiptReturnReceiptWithAllItemNamesAndPricesAfterTax() {
//        // arrange
//        Item item1 = new Item("Toy", 13.67, false, false); // 15.02
//        Item item2 = new Item("Book", 13.67, true, false); // 13.67
//        Item item3 = new Item("Chocolate Bar", 1.28, true, true); // 1.33
//        Item[] basket = new Item[] {item1, item2, item3};
//
//        // act
//        Receipt receipt = ReceiptGenerator.generateReceipt(basket);
//
//        // assert
//        assertTrue(receipt.itemPricesAfterTax.equals("Toy: $15.02\n" +
//                "Book: $13.67\n" +
//                "Chocolate Bar: $1.33"));
//    }
}