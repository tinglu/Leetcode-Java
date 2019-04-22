package GreedyAlgorithms;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertArrayEquals;

public class ProductOfAllOtherNumbers {

    // My solution - 3 arrays and 3 for loops
//    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {
//
//        // make an array of the products
//        if (intArray.length < 2) throw new IllegalArgumentException("array has less than 2 items");
//
//        int[] productsToThisIdx = new int[intArray.length];
//        int[] productsToThisIdxReversed = new int[intArray.length];
//
//        productsToThisIdx[0] = intArray[0];
//
//        for (int i = 1; i < intArray.length; i++) {
//            productsToThisIdx[i] = productsToThisIdx[i - 1] * intArray[i];
//        }
//
//        productsToThisIdxReversed[intArray.length - 1] = intArray[intArray.length - 1];
//        for (int i = intArray.length - 2; i >= 0; i--) {
//            productsToThisIdxReversed[i] = productsToThisIdxReversed[i + 1] * intArray[i];
//        }
//
//        System.out.println();
//        System.out.println(Arrays.toString(intArray));
//        System.out.println(Arrays.toString(productsToThisIdx));
//        System.out.println(Arrays.toString(productsToThisIdxReversed));
//
//        int[] result = new int[intArray.length];
//        for (int i = 0; i < intArray.length; i++) {
//            if (i == 0) {
//                result[i] = productsToThisIdxReversed[i + 1];
//            } else if (i == intArray.length - 1) {
//                result[i] = productsToThisIdx[i - 1];
//            } else {
//                result[i] = productsToThisIdx[i - 1] * productsToThisIdxReversed[i + 1];
//            }
//        }
//
//        return result;
//    }

    // Interview Cake's solution - 1 array & 2 loops !!!
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        // make an array of the products
        if (intArray.length < 2) throw new IllegalArgumentException("array has less than 2 items");

        int[] productsExceptThisIdx = new int[intArray.length];
        int productSoFar = 1;


        for (int i = 0; i < intArray.length; i++) {
            productsExceptThisIdx[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsExceptThisIdx[i] *= productSoFar;
            productSoFar *= intArray[i];
        }

        return productsExceptThisIdx;
    }


    // tests

    @Test
    public void smallArrayTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[]{1, 2, 3});
        final int[] expected = new int[]{6, 3, 2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[]{8, 2, 4, 3, 1, 5});
        final int[] expected = new int[]{120, 480, 240, 320, 960, 192};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayHasOneZeroTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[]{6, 2, 0, 3});
        final int[] expected = new int[]{0, 0, 36, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoZerosTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[]{4, 0, 9, 1, 0});
        final int[] expected = new int[]{0, 0, 0, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneNegativeNumberTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[]{-3, 8, 4});
        final int[] expected = new int[]{32, -12, -24};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void allNegativeNumbersTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[]{-7, -1, -4, -2});
        final int[] expected = new int[]{-8, -56, -14, -28};
        assertArrayEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        getProductsOfAllIntsExceptAtIndex(new int[]{});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        getProductsOfAllIntsExceptAtIndex(new int[]{1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ProductOfAllOtherNumbers.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}