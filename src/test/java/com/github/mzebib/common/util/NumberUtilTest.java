package com.github.mzebib.common.util;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class NumberUtilTest {

    @Test
    public void testFindMaxNumber() {
        assertEquals(10, NumberUtil.findMaxNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertEquals(1000, NumberUtil.findMaxNumber(new int[]{1000, 750, 500, 250, 0}));
        assertEquals(200, NumberUtil.findMaxNumber(new int[]{100, 50, 150, 200, 25, 10}));
    }

    @Test
    public void testFindMinNumber() {
        assertEquals(1, NumberUtil.findMinNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertEquals(0, NumberUtil.findMinNumber(new int[]{1000, 750, 500, 250, 0}));
        assertEquals(10, NumberUtil.findMinNumber(new int[]{100, 50, 150, 200, 25, 10}));
    }

    @Test
    public void testSortArray() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, NumberUtil.sort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertArrayEquals(new int[]{0, 250, 500, 750, 1000}, NumberUtil.sort(new int[]{1000, 750, 500, 250, 0}));
        assertArrayEquals(new int[]{10, 25, 50, 100, 150, 200}, NumberUtil.sort(new int[]{100, 50, 150, 200, 25, 10}));

        assertArrayEquals(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, NumberUtil.sort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, true));
        assertArrayEquals(new int[]{1000, 750, 500, 250, 0}, NumberUtil.sort(new int[]{1000, 750, 500, 250, 0}, true));
        assertArrayEquals(new int[]{200, 150, 100, 50, 25, 10}, NumberUtil.sort(new int[]{100, 50, 150, 200, 25, 10}, true));
    }

    @Test
    public void testExtractDigits() {
        assertArrayEquals(new Integer[]{1}, NumberUtil.extractDigits(1));
        assertArrayEquals(new Integer[]{2, 5}, NumberUtil.extractDigits(25));
        assertArrayEquals(new Integer[]{1, 0, 0}, NumberUtil.extractDigits(100));
        assertArrayEquals(new Integer[]{1, 0, 1, 1}, NumberUtil.extractDigits(1011));
        assertArrayEquals(new Integer[]{1, 0, 2, 2}, NumberUtil.extractDigits(1022));
    }

    @Test
    public void testFactorial() {
        assertEquals(1, NumberUtil.factorial(1));
        assertEquals(2, NumberUtil.factorial(2));
        assertEquals(6, NumberUtil.factorial(3));
        assertEquals(24, NumberUtil.factorial(4));
        assertEquals(120, NumberUtil.factorial(5));
        assertEquals(40320, NumberUtil.factorial(8));
    }

    @Test
    public void testFindIndex() {
        assertEquals(4, NumberUtil.findIndex(new int[]{1, 2, 3, 3, 6, 6, 7, 9}, 6));
        assertEquals(0, NumberUtil.findIndex(new int[]{10}, 10));
        assertEquals(-1, NumberUtil.findIndex(new int[]{-110, 103}, 10));
        assertEquals(0, NumberUtil.findIndex(new int[]{22, 22, 22, 22}, 22));
    }

    @Test
    public void testCalculateAverage() {
        assertEquals(0.5, NumberUtil.calculateAverage(new int[]{0, 1}), 0);
        assertEquals(55, NumberUtil.calculateAverage(new int[]{100, 10}), 0);
        assertEquals(20, NumberUtil.calculateAverage(new int[]{20, 20, 20}), 0);
        assertEquals(2.0, NumberUtil.calculateAverage(new int[]{2}), 0);
    }

    @Test
    public void testIsPrimeNumber() {
        assertTrue(NumberUtil.isPrimeNumber(2));
        assertTrue(NumberUtil.isPrimeNumber(3));
        assertTrue(NumberUtil.isPrimeNumber(5));
        assertTrue(NumberUtil.isPrimeNumber(7));
        assertTrue(NumberUtil.isPrimeNumber(11));
        assertTrue(NumberUtil.isPrimeNumber(13));
        assertTrue(NumberUtil.isPrimeNumber(919));
        assertFalse(NumberUtil.isPrimeNumber(1));
        assertFalse(NumberUtil.isPrimeNumber(0));
        assertFalse(NumberUtil.isPrimeNumber(15));
        assertFalse(NumberUtil.isPrimeNumber(100));
    }

    @Test
    public void testFindGCD() {
        assertEquals(5, NumberUtil.findGCD(55, 5));
        assertEquals(4, NumberUtil.findGCD(16, 4));
        assertEquals(4, NumberUtil.findGCD(1052, 52));
        assertEquals(5, NumberUtil.findGCD(15, 65));
        assertEquals(1, NumberUtil.findGCD(55, 54));
    }
}
