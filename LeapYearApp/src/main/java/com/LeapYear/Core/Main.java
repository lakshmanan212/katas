package com.LeapYear.Core;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Enter a year to check if it's a leap year:");
        int year = scanner.nextInt();

        boolean isLeapYear = LeapYearCalculator.isLeapYear(year);

        if (isLeapYear) {
            LOGGER.info("{}" + " is a leap year.", year);
        } else {
            LOGGER.info("{}" + " is not a leap year.", year);
        }

        scanner.close();
    }

}
