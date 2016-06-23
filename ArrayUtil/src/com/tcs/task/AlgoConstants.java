package com.tcs.task;

/**
 * @author Jagadeesan
 * 
 * Enum <code>AlgoConstants</code> declares constants
 * that identify the algorithm to be used. 
 * Changes or additions to constants should be
 * supported with corresponding algorithm implementations.
 *
 */
public enum AlgoConstants {

	/**
	 * Constant denotes a java.util.Set implementation
	 * to be used to perform duplicate check
	 */
	ALGO_SET,
	/**
	 * Constant denotes a java.util.List implementation
	 * to be used to perform duplicate check
	 */	
    ALGO_LIST,
	/**
	 * Constant denotes a 'NO' hashing or java.util.Collections
	 * approach to be used to perform duplicate check.
	 */    
    ALGO_NO_HASH;
}
