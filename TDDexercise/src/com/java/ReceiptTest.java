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
        Item taxExemptItem = new Item(1.00, true, false);
        Item[] basket = new Item[]{taxExemptItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        //assert
        assertEquals(0, receipt.totalTax);
    }

    @Test
    public void Given1TaxExemptItemInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToItemPrice() {
        // arrange
        Item taxExemptItem = new Item(1.00, true, false);
        Item[] basket = new Item[]{taxExemptItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        //assert
        assertEquals(taxExemptItem.price, receipt.totalDue);
    }

    @Test
    public void Given1TaxableItemInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo10PercentOfItemPrice() {
        // arrange
        Item taxableItem = new Item(1.00, false, false);
        Item[] basket = new Item[]{taxableItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.10, receipt.totalTax);
    }

    @Test
    public void Given1TaxableItemInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToItemPriceAfterTax() {
        // arrange
        Item taxableItem = new Item(1.00, false, false);
        Item[] basket = new Item[]{taxableItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(1.10, receipt.totalDue);
    }

    @Test
    public void Given1TaxExemptImportedItemInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo5PercentOfItemPrice() {
        // arrange
        Item taxableItem = new Item(1.00, true, true);
        Item[] basket = new Item[]{taxableItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.05, receipt.totalTax);
    }

    @Test
    public void Given1TaxExemptImportedItemInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToItemPriceAfterTax() {
        // arrange
        Item taxableItem = new Item(1.00, true, true);
        Item[] basket = new Item[]{taxableItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(1.05, receipt.totalDue);
    }

    @Test
    public void Given1TaxableImportedItemInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo15PercentOfItemPrice() {
        // arrange
        Item taxableItem = new Item(1.00, false, true);
        Item[] basket = new Item[]{taxableItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.15, receipt.totalTax);
    }

    @Test
    public void Given1TaxableImportedItemInBasketGenerateReceiptReturnsReceiptWithTotalDueEqualToItemPriceAfterTax() {
        // arrange
        Item taxableItem = new Item(1.00, false, true);
        Item[] basket = new Item[]{taxableItem};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(1.15, receipt.totalDue);
    }

    @Test
    public void Given3TaxableItemsInBasketGenerateReceiptReturnsReceiptWithTotalTaxEqualTo15PercentOfAllItemPrices() {
        // arrange
        Item taxableItem1 = new Item(1.00, false, false);
        Item taxableItem2 = new Item(1.50, false, false);
        Item taxableItem3 = new Item(1.25, false, false);
        Item[] basket = new Item[]{taxableItem1, taxableItem2, taxableItem3};

        // act
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);

        // assert
        assertEquals(0.375, receipt.totalTax);
    }
}