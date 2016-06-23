/*
 * 
 * Project ArrayUtil demonstrates various methods
 * using which duplicate entries can be removed from 
 * an array of java.lang.Integer. 
 * 
 */
package com.tcs.task.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tcs.task.AlgoConstants;

/**
 * @author Jagadeesan
 * 
 *         Class <code>CheckDuplicate</code> declares utility methods to remove
 *         duplicates from java.lang.Integer array.
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
     * Method which removes duplicates from arg java.lang.Integer array. method
     * delegates call to corresponding utility method based on enum argument
     * passed.
     * 
     * @param arrayToCleanse
     *            Array to be duplicate checked.
     * @param algo
     *            Algorithm to be used to remove duplicates.
     * @return Integer[] An Integer array without duplicates
     */
    public Integer[] findAndRemoveDuplicates(Integer[] arrayToCleanse, AlgoConstants algo) {

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
     * @param array      The Integer[] to be duplicate checked.
     * @return Integer[] An array without duplicates.
     */
    private Integer[] removeDuplicates(Integer[] array) {

        if (array != null && array.length > 0) {
            final Float load_factor = 0.75F;
            final Integer initial_cap = Math.round(array.length / load_factor);
            Set<Integer> integerSet = new HashSet<Integer>(initial_cap, load_factor);
            integerSet.addAll(Arrays.asList(array));
            return integerSet.toArray(new Integer[0]);
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
     * @param array      The Integer[] to be duplicate checked.
     * @return Integer[] An array without duplicates.
     */
    private Integer[] removeDuplicatesKeepOrder(Integer[] array) {

        if (array != null && array.length > 0) {
            // assuming 1/3rd of an array could be duplicates,
            // initial capacity allocated is 70%
            final Integer initial_cap = Math.round(array.length - (array.length / 3));
            List<Integer> integerList = new ArrayList<Integer>(initial_cap);
            for (Integer eachArrElement : array) {
                if (!integerList.contains(eachArrElement)) {
                    integerList.add(eachArrElement);
                }
            }
            return integerList.toArray(new Integer[0]);
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
     * @param array      The Integer[] to be duplicate checked.
     * @return Integer[] An array without duplicates.
     */
    private Integer[] removeDuplicatesNoHash(Integer[] array) {

        if (array != null && array.length > 0) {
            Arrays.sort(array);
            Integer k = 0;
            Integer[] tempArr = new Integer[array.length];
            Integer previous = array[0];
            tempArr[k] = previous;
            for (Integer i = 1; i < array.length; i++) {
                Integer ch = array[i];
                if (previous != ch) {
                    tempArr[++k] = ch;
                }
                previous = ch;
            }
            Integer[] result = new Integer[k + 1];
            for (Integer j = 0; j < (k + 1); j++) {
                result[j] = tempArr[j];
            }
            return result;
        } else {
            throw new RuntimeException("arg array is null or empty");
        }
    }
}
