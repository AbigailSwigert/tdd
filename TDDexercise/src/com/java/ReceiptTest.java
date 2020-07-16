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

}