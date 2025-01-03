package com.LeapYear.Core;

public class LeapYearCalculator {

    /**
     * Determines if a given year is a leap year.
     * @param year The year to check.
     * @return true if the year is a leap year, false otherwise.
     */

    public static boolean isLeapYear(int year) {
        if (year % 4000 == 0) {
            return false; // Divisible by 4000
        }
        if (year % 400 == 0) {
            return true; // Divisible by 400
        }
        if (year % 100 == 0) {
            return false; // Divisible by 100 but not 400
        }
        if (year % 4 == 0) {
            return true; // Divisible by 4 but not 100
        }
        return false; // Not divisible by 4
    }

}
