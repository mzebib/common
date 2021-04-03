package com.github.mzebib.common.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        int[] array = {0,10,20,30,40,50};

        assertTrue(BinarySearch.binarySearch(array, 10));
        assertTrue(BinarySearch.binarySearch(array, 40));
        assertFalse(BinarySearch.binarySearch(array, 25));
        assertFalse(BinarySearch.binarySearch(array, 100));
    }
}
