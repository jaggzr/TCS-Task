package com.tcs.task.data.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jagadeesan
 * 
 * Class <code>CheckDuplicate</code> declares utility methods
 * to remove duplicates from java.lang.Integer array.
 *
 */
public class CheckDuplicate {

	/**
	 * Default no-arg constructor
	 */
	public CheckDuplicate() {
		
	}
	
	/**
	 * Method removes duplicates using a java.util.Set implementation.
	 * Load factor 0.75 is assumed to ensure size safety and avoid
	 * frequent re-hashing. 
	 * 
	 * De-limits of this approach - Use of hashing algorithms, memory
	 * allocations.
	 * 
	 * @param array
	 * 		  The Integer[] to be duplicate checked.
	 * @return Integer[]
	 * 		   An array without duplicates.
	 */
	public static Integer[] removeDuplicates(Integer[] array){
		
		if(array != null && array.length > 0) {
			final Float load_factor = 0.75F;
			final Integer initial_cap = Math.round(array.length/load_factor);
			Set<Integer> integerSet = new HashSet<Integer>(initial_cap, load_factor);
			integerSet.addAll(Arrays.asList(array));
			return integerSet.toArray(new Integer[0]);
		} else {
			throw new RuntimeException("arg array is null or empty");
		}
	}
	
	/**
	 * Method removes duplicates using a java.util.List implementation.
	 * An initial capacity of 65% has been assumed to reduce resizing
	 * cycles.
	 * 
	 * De-limits of this approach - Use of List interface where
	 * constant resizing is needed to ensure capacity for new
	 * incoming elements, memory allocations, copying of arrays
	 * whenever the List is resized.
	 * 
	 * @param array
	 * 		  The Integer[] to be duplicate checked.
	 * @return Integer[]
	 * 		   An array without duplicates.
	 */	
	public static Integer[] removeDuplicatesKeepOrder(Integer[] array) {
		
		if(array != null && array.length > 0) {
			// assuming 1/3rd of an array could be duplicates,
			// initial capacity allocated is 70%
			final Integer initial_cap = Math.round(array.length - (array.length/3));
			List<Integer> integerList = new ArrayList<Integer>(initial_cap);
			for(Integer eachArrElement : array) {
				if(!integerList.contains(eachArrElement)) {
					integerList.add(eachArrElement);
				}
			}
			return integerList.toArray(new Integer[0]);
		} else {
			throw new RuntimeException("arg array is null or empty");
		}
	}
	
	/**
	 * Method removes duplicates without hashing 
	 * or Collections framework.
	 * 
	 * De-limits of this approach - Time consuming iterations,
	 * need for multiple temporary variables and arrays,
	 * requires more unit testing effort to ensure result 
	 * under several scenarios.
	 * 
	 * @param array
	 * 		  The Integer[] to be duplicate checked.
	 * @return Integer[]
	 * 		   An array without duplicates.
	 */		
	public static Integer[] removeDuplicatesNoHash(Integer[] array){

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
