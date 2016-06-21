/*
 * 
 * Project ArrayUtil demonstrates various methods
 * using which duplicate entries can be removed from 
 * an array of java.lang.Integer. 
 * 
 */
package com.tcs.task.data;

import com.tcs.task.data.util.CheckDuplicate;

/**
 * @author Jagadeesan
 * 
 * Class <code>DeDup</code> declares an Integer array initialized with
 * random numbers from which duplicates will be removed.
 *
 */
public class DeDup {
	
	private Integer[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};
	
	/**
	 * Method randomInteger's getter method
	 * 
	 * @return Integer[]
	 * 		   An array of Integers.
	 */
	public Integer[] getRandomIntegers() {
		return randomIntegers;
	}
	
	/**
	 * Method which removes duplicates from arg java.lang.Integer array.
	 * method delegates call to corresponding utility method based on
	 * enum argument passed.
	 * 
	 * @param arrayToCleanse
	 * 		  Array to be duplicate checked.
	 * @param algo
	 * 		  Algorithm to be used to remove duplicates.
	 * @return Integer[]
	 * 		   An Integer array without duplicates
	 */
	public Integer[] findAndRemoveDuplicates(Integer[] arrayToCleanse, AlgoConstants algo){
		
	      switch (algo) {
          case ALGO_LIST:
              return CheckDuplicate.removeDuplicates(arrayToCleanse);
          case ALGO_SET:
              return CheckDuplicate.removeDuplicatesKeepOrder(arrayToCleanse);
          case ALGO_NO_HASH:
              return CheckDuplicate.removeDuplicatesNoHash(arrayToCleanse);
          default:
              throw new AssertionError("Unknown operations " + this);
      }
	}
}
