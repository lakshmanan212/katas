package com.DevelopmentBook;

import java.util.*;

public class BookStore {

    private static final double BOOK_PRICE = 50.0;
    private static final double[] DISCOUNTS = {0.0, 0.05, 0.10, 0.20, 0.25};

    public double calculatePrice(int[] basket) {
        if (basket == null || basket.length == 0) {
            return 0.0;
        }
        return calculatePriceHelper(basket);
    }

    private double calculatePriceHelper(int[] basket) {

        if (Arrays.stream(basket).allMatch(count -> count == 0)) {
            return 0.0;
        }

        double minPrice = Double.MAX_VALUE;


        for (int groupSize = 1; groupSize <= 5; groupSize++) {
            int[] newBasket = basket.clone();
            int distinctCount = 0;

            for (int i = 0; i < newBasket.length && distinctCount < groupSize; i++) {
                if (newBasket[i] > 0) {
                    newBasket[i]--;
                    distinctCount++;
                }
            }

            if (distinctCount == groupSize) {
                double groupPrice = groupSize * BOOK_PRICE * (1 - DISCOUNTS[groupSize - 1]);
                minPrice = Math.min(minPrice, groupPrice + calculatePriceHelper(newBasket));
            }
        }

        return minPrice;
    }

}
