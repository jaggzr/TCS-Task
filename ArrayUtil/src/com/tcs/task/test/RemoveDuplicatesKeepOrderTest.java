package com.tcs.task.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.tcs.task.data.AlgoConstants;
import com.tcs.task.data.DeDup;

/**
 * @author Jagadeesan
 * 
 * Class <code>RemoveDuplicatesKeepOrderTest</code> provides Junit test case
 * to check if removeDuplicatesKeepOrder method removes duplicates 
 * from java.lang.Integer array.
 *
 */
public class RemoveDuplicatesKeepOrderTest {

	/**
	 * This method tests if the resulting array has any duplicate values. This
	 * test passes if the array does not contain any duplicates.
	 * 
	 */
	@Test
	public void testRemoveDuplicatesKeepOrder() {
		DeDup deDup = new DeDup();
		Integer[] sortedArray = deDup.findAndRemoveDuplicates(deDup.getRandomIntegers(), AlgoConstants.ALGO_SET);
		Arrays.sort(sortedArray);
		int size = sortedArray.length;
		int i, j;
		for (i = 0; i < size; i++)
			for (j = i + 1; j < size; j++)
				if (sortedArray[i] == sortedArray[j])
					fail("Array still contains duplicate elements");
	}
}
