/*
 * 
 * Project ArrayUtil demonstrates various methods
 * using which duplicate entries can be removed from 
 * an array of integers. 
 * 
 */
package com.tcs.task.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.tcs.task.AlgoConstants;

/**
 * @author Jagadeesan
 * 
 *         Class <code>CheckDuplicate</code> declares utility methods to remove
 *         duplicates from an array of integers.
 *
 */
public class CheckDuplicate {

    private static CheckDuplicate _instance = null;

    /**
     * Private no-arg constructor
     */
    private CheckDuplicate() {

    }

    /**
     * 
     * Static get method to acquire singleton instance of Class
     * <code>CheckDuplicate</code>
     * 
     * @return singleton instance CheckDuplicate
     */
    public static CheckDuplicate getInstance() {

        synchronized (CheckDuplicate.class) {
            if (CheckDuplicate._instance == null) {
                CheckDuplicate._instance = new CheckDuplicate();
            }
        }
        return CheckDuplicate._instance;
    }

    /**
     * Method which removes duplicates from arg integer array. method
     * delegates call to corresponding utility method based on enum argument
     * passed.
     * 
     * @param arrayToCleanse
     *            Array to be duplicate checked.
     * @param algo
     *            Algorithm to be used to remove duplicates.
     * @return int[] An integer array without duplicates
     */
    public int[] findAndRemoveDuplicates(int[] arrayToCleanse, AlgoConstants algo) {

        switch (algo) {
        case ALGO_LIST:
            return removeDuplicates(arrayToCleanse);
        case ALGO_SET:
            return removeDuplicatesKeepOrder(arrayToCleanse);
        case ALGO_NO_HASH:
            return removeDuplicatesNoHash(arrayToCleanse);
        default:
            throw new AssertionError("Unknown operations " + this);
        }
    }

    /**
     * Method removes duplicates using a java.util.Set implementation. Load
     * factor 0.75 is assumed to ensure size safety and avoid frequent
     * re-hashing.
     * 
     * De-limits of this approach - Use of hashing algorithms, memory
     * allocations.
     * 
     * With usage of Set interface, overhead increases with element size.
     * As we add more elements into the set, heap retention and overhead increases
     * which is also not predictive in all cases. So this approach should be avoided
     * if the element size is too huge say in the order of several 100,000 objects.
     * 
     * @param array      The int[] to be duplicate checked.
     * @return int[] An array without duplicates.
     */
    private int[] removeDuplicates(int[] array) {

        if (array != null && array.length > 0) {
            final Float load_factor = 0.75F;
            final int initial_cap = Math.round(array.length / load_factor);

            /* A Set is a collection object that cannot have a duplicate values, so
             by converting the array to a set the duplicate value will be removed.*/
            Set<Integer> integerSet = new HashSet<Integer>(initial_cap, load_factor);
            for (int i = 0; i < array.length; i++) {
                integerSet.add(array[i]);
            }
            // copying the elements from the Set into an array
            int[] resultArray = new int[integerSet.size()];
            int i = 0;
            for (Integer u : integerSet) {
                resultArray[i++] = u;
            }
            return resultArray;
        } else {
            throw new RuntimeException("arg array is null or empty");
        }
    }

    /**
     * Method removes duplicates using a java.util.List implementation. An
     * initial capacity of 65% has been assumed to reduce resizing cycles.
     * 
     * De-limits of this approach - Use of List interface where constant
     * resizing is needed to ensure capacity for new incoming elements, memory
     * allocations, copying of arrays whenever the List is resized.
     * 
     * With usage of List interface, overhead increases with element size.
     * Adding more elements to the list also increases overhead but if element
     * size becomes element size * (n+1) or element size * (n+2), overhead will 
     * not increase or decrease by a constant factor n or a derivative of n. 
     * So this is not predictive too. Avoid this approach if the element 
     * size is too huge.
     * 
     * @param array      The int[] to be duplicate checked.
     * @return int[] An array without duplicates.
     */
    private int[] removeDuplicatesKeepOrder(int[] array) {

        if (array != null && array.length > 0) {
            // assuming 1/3rd of an array could be duplicates,
            // initial capacity allocated is 70%
            final int initial_cap = Math.round(array.length - (array.length / 3));
            List<Integer> integerList = new ArrayList<Integer>(initial_cap);
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                if (!integerList.contains(array[i])) {
                    integerList.add(array[i]);
                }
            }
            Iterator<Integer> valueIterator = numbers.iterator();
            int[] resultArray = new int[numbers.size()];
            int i = 0;
            while (valueIterator.hasNext()) {
                resultArray[i] = valueIterator.next();
                i++;
            }
            return resultArray;
        } else {
            throw new RuntimeException("arg array is null or empty");
        }
    }

    /**
     * Method removes duplicates without hashing or Collections framework.
     * 
     * De-limits of this approach - Time consuming iterations, need for multiple
     * temporary variables and arrays,
     * 
     * Use the pure array approach if the element size is huge. It can guarantee 
     * low heap size and low overhead when compared to collections but adds to the time cost.
     * 
     * @param array      The int[] to be duplicate checked.
     * @return int[] An array without duplicates.
     */
    private int[] removeDuplicatesNoHash(int[] array) {

        if (array != null && array.length > 0) {
            Arrays.sort(array);
            int k = 0;
            int[] tempArr = new int[array.length];
            int previous = array[0];
            tempArr[k] = previous;
            for (int i = 1; i < array.length; i++) {
                int ch = array[i];
                if (previous != ch) {
                    tempArr[++k] = ch;
                }
                previous = ch;
            }
            int[] result = new int[k + 1];
            for (int j = 0; j < (k + 1); j++) {
                result[j] = tempArr[j];
            }
            return result;
        } else {
            throw new RuntimeException("arg array is null or empty");
        }
    }
}
