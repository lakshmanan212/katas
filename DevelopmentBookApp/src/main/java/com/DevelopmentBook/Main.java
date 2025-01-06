package com.DevelopmentBook;

import java.util.Scanner;

public class Main {

    public void startDevelopmentBookApp(){
        int[] basket = getUserInputArray();
        BookStore store = new BookStore();
        double price = store.calculatePrice(basket);
    }


    public static int[] getUserInputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of book types (e.g., 5 for 5 different books):");
        int size = scanner.nextInt();

        int[] basket = new int[size];
        System.out.println("Enter the number of copies for each book type:");

        for (int i = 0; i < size; i++) {
            System.out.print("Book " + (i + 1) + ": ");
            basket[i] = scanner.nextInt();
        }

        scanner.close();
        return basket;
    }

}
