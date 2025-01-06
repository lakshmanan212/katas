package com.DevelopmentBook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class BookStoreTest {

    @Test
    void testEmptyBasket() {
        BookStore store = new BookStore();
        int[] basket = {};
        assertEquals(0.0, store.calculatePrice(basket), 0.01);
    }

    @Test
    void testSingleBook() {
        BookStore store = new BookStore();
        int[] basket = {1, 0, 0, 0, 0};
        assertEquals(50.0, store.calculatePrice(basket), 0.01);
    }

    @Test
    void testTwoDifferentBooks() {
        BookStore store = new BookStore();
        int[] basket = {1, 1, 0, 0, 0};
        assertEquals(95.0, store.calculatePrice(basket), 0.01); // 5% discount
    }

    @Test
    void testThreeDifferentBooks() {
        BookStore store = new BookStore();
        int[] basket = {1, 1, 1, 0, 0};
        assertEquals(135.0, store.calculatePrice(basket), 0.01); // 10% discount
    }

    @Test
    void testFourDifferentBooks() {
        BookStore store = new BookStore();
        int[] basket = {1, 1, 1, 1, 0};
        assertEquals(160.0, store.calculatePrice(basket), 0.01); // 20% discount
    }

    @Test
    void testFiveDifferentBooks() {
        BookStore store = new BookStore();
        int[] basket = {1, 1, 1, 1, 1};
        assertEquals(187.5, store.calculatePrice(basket), 0.01); // 25% discount
    }


    @Test
    void testMixedBasket() {
        BookStore store = new BookStore();
        int[] basket = {2, 2, 2, 1, 1};
        assertEquals(320.0, store.calculatePrice(basket), 0.01);
    }

    @Test
    void testSingleBookMultipleCopies() {
        BookStore store = new BookStore();
        int[] basket = {4, 0, 0, 0, 0};
        assertEquals(200.0, store.calculatePrice(basket), 0.01);
    }

    @Test
    void testEdgeCaseAllZero() {
        BookStore store = new BookStore();
        int[] basket = {0, 0, 0, 0, 0};
        assertEquals(0.0, store.calculatePrice(basket), 0.01);
    }

}
