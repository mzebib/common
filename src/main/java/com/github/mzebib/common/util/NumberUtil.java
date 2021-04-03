package com.github.mzebib.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains number related utility methods.
 * @author mzebib
 */
public class NumberUtil {

    private NumberUtil() {
    }

    /**
     * Finds and returns the maximum number in the given integer array.
     * @param numbers array
     * @return max number
     */
    public static int findMaxNumber(int[] numbers) {
        if (numbers.length > 0) {
            int max = numbers[0];
            for (int num : numbers) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }

        return -1;
    }

    /**
     * Finds and returns the minimum number in the given integer array.
     * @param numbers array
     * @return min number
     */
    public static int findMinNumber(int[] numbers) {
        if (numbers.length > 0) {
            int min = numbers[0];
            for (int num : numbers) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        }

        return -1;
    }

    /**
     * Sorts the given integer array in ascending order.
     * @param numbers to be sorted
     * @return sorted array
     */
    public static int[] sort(int[] numbers) {
        return sort(numbers, false);
    }

    /**
     * Sorts the given integer array in ascending/descending order.
     * @param numbers to be sorted
     * @param descending true for descending, false for ascending
     * @return sorted array
     */
    public static int[] sort(int[] numbers, boolean descending) {
        if (numbers.length > 0) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers.length; j++) {
                    if (descending) {
                        if (numbers[i] > numbers[j]) {
                            int temp = numbers[i];
                            numbers[i] = numbers[j];
                            numbers[j] = temp;
                        }
                    } else {
                        if (numbers[i] < numbers[j]) {
                            int temp = numbers[i];
                            numbers[i] = numbers[j];
                            numbers[j] = temp;
                        }
                    }
                }
            }
        }

        return numbers;
    }

    /**
     * Extracts digits for the given number and returns digits in an array.
     * @param num number to extract digits
     * @return digits
     */
    public static Integer[] extractDigits(int num) {
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            int digit = num % 10;
            list.add(digit);
            num = num/10;
        }

        Integer[] digits = new Integer[list.size()];

        int index = 0;
        for (int i=list.size()-1; i >= 0; i--) {
            digits[index] = list.get(i);
            index++;
        }

        return digits;
    }

    /**
     * Factorial of n is the product of all positive descending integers.
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1) return 1;
        return n*factorial(n-1);
    }

    /**
     * Finds index for the given integer in an integer array.
     * @param numbers
     * @param n
     * @return
     */
    public static int findIndex(int[] numbers, int n) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Calculates average for the given integer array.
     * @param numbers array
     * @return average
     */
    public static double calculateAverage(int[] numbers) {
        int sum = 0;
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            sum = sum + numbers[i];
        }

        return (double) sum/length;
    }

    /**
     * Checks if given integer is a prime number.
     * A prime number is a number that is divisible only by 1 and itself.
     * @param n number to check if prime
     * @return true if prime, false if not
     */
    public static boolean isPrimeNumber(int n) {
        if (n < 2) return false;

        for(int i=2; 2*i<n; i++) {
            if (n%i==0) return false;
        }

        return true;
    }

    /**
     * Finds greatest common divisor (GCD).
     * The GCD of two numbers is the largest positive integer
     * that divides both the numbers without any remainder.
     * @param p number
     * @param q number
     * @return greatest common divisor, if none then -1
     */
    public static int findGCD(int p, int q) {
        int num;

        if (p > q) {
            num = q;
        } else  {
            num = p;
        }

        for (int i = num; i > 0; i--) {
            if (p % i == 0 && q % i == 0) return i;
        }

        return -1;
    }

}
