package com.github.mzebib.common.util;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author mzebib
 */
public class QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] arr = {4,10,3,5,8,2,9,7,1,6};

        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10}, arr);
    }
}
