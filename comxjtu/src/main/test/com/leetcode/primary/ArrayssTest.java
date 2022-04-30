package com.leetcode.primary; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.Arrays;

/** 
* Arrayss Tester. 
* 
* @author JS 
* @since 04/30/2022 
* @version 1.0 
*/ 
public class ArrayssTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: maxProfit(int[] prices) 
* 
*/ 
@Test
public void testMaxProfit() throws Exception { 
//TODO: Test goes here...
    Arrayss arrayss = new Arrayss();
    System.out.println(arrayss.maxProfit(new int[]{7,1,5,3,6,4}));
    System.out.println(arrayss.maxProfit(new int[]{1,2,3,4,5}));
    System.out.println(arrayss.maxProfit(new int[]{7,6,4,3,1}));
}


/**
*
* Method: binarySearch(int[] nums, int val, int lo, int hi)
*
*/
@Test
public void testBinarySearch() throws Exception {
//TODO: Test goes here...
    Arrayss arrayss = new Arrayss();
    System.out.println(Arrays.toString(arrayss.twoSum(new int[]{2,7,11,15},9)));
    System.out.println(Arrays.toString(arrayss.twoSum(new int[]{3,2,4},6)));
    System.out.println(Arrays.toString(arrayss.twoSum(new int[]{3,3},6)));
}

} 
