package com.LeapYear;

public class LeapYearCalculator {

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
