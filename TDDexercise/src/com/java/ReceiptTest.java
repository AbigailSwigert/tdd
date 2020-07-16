package com.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    @Test
    public  void emptyShoppingBasketReturnsEmptyReceipt() {
        Item[] basket = new Item[]{};
        Receipt receipt = ReceiptGenerator.generateReceipt(basket);
        assertNotNull(receipt);
    }
}