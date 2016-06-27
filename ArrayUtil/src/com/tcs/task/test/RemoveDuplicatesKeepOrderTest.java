package com.tcs.task.test;

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

import com.tcs.task.AlgoConstants;
import com.tcs.task.util.CheckDuplicate;

/**
 * @author Jagadeesan
 * 
 *         Class <code>RemoveDuplicatesKeepOrderTest</code> provides Junit test
 *         case to check if removeDuplicatesKeepOrder method removes duplicates
 *         from integer array.
 *
 */
public class RemoveDuplicatesKeepOrderTest {

    /**
     * randomIntegers is an integer array initialized with random numbers from
     * which duplicates will be removed.
     *
     */
    private int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19,
            1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
            19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

    /**
     * Method randomInteger's getter method
     * 
     * @return int[] An array of integers.
     */
    public int[] getRandomIntegers() {
        return randomIntegers;
    }

    /**
     * This method tests if the resulting array has any duplicate values. This
     * test passes if the array does not contain any duplicates.
     * 
     */
    @Test
    public void testRemoveDuplicatesKeepOrder() {
        int[] sortedArray = CheckDuplicate.getInstance().findAndRemoveDuplicates(getRandomIntegers(),
                AlgoConstants.ALGO_SET);
        Arrays.sort(sortedArray);
        int size = sortedArray.length;
        int i, j;
        for (i = 0; i < size; i++) {
            for (j = i + 1; j < size; j++) {
                if (sortedArray[i] == sortedArray[j]) {
                    fail("Array still contains duplicate elements");
                }
            }
        }
    }

    /**
     * This method tests if RuntimeException occurs when null value is passed 
     * instead of integer array.
     * 
     */
    @SuppressWarnings("unused")
    @Test(expected = RuntimeException.class)
    public void throwsRuntimeExceptionWhenNull() {
        int[] sortedArray = CheckDuplicate.getInstance().findAndRemoveDuplicates(null, AlgoConstants.ALGO_SET);
    }

}
