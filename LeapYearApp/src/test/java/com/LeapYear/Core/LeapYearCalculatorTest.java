package com.LeapYear.Core;

import com.LeapYear.Core.LeapYearCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearCalculatorTest {

    @Test
    void testYearDivisibleBy400IsLeapYear() {
        assertTrue(LeapYearCalculator.isLeapYear(2000), "Year 2000 should be a leap year.");
        assertTrue(LeapYearCalculator.isLeapYear(2400), "Year 2400 should be a leap year.");
    }

    @Test
    void testYearDivisibleBy100ButNotBy400IsNotLeapYear() {
        assertFalse(LeapYearCalculator.isLeapYear(1700), "Year 1700 should not be a leap year.");
        assertFalse(LeapYearCalculator.isLeapYear(1800), "Year 1800 should not be a leap year.");
        assertFalse(LeapYearCalculator.isLeapYear(1900), "Year 1900 should not be a leap year.");
        assertFalse(LeapYearCalculator.isLeapYear(2100), "Year 2100 should not be a leap year.");
    }

    @Test
    void testYearDivisibleBy4ButNotBy100IsLeapYear() {
        assertTrue(LeapYearCalculator.isLeapYear(2008), "Year 2008 should be a leap year.");
        assertTrue(LeapYearCalculator.isLeapYear(2012), "Year 2012 should be a leap year.");
        assertTrue(LeapYearCalculator.isLeapYear(2016), "Year 2016 should be a leap year.");
    }

    @Test
    void testYearNotDivisibleBy4IsNotLeapYear() {
        assertFalse(LeapYearCalculator.isLeapYear(2017), "Year 2017 should not be a leap year.");
        assertFalse(LeapYearCalculator.isLeapYear(2018), "Year 2018 should not be a leap year.");
        assertFalse(LeapYearCalculator.isLeapYear(2019), "Year 2019 should not be a leap year.");
    }
}
