package com.leetcode.everyday;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/** 
* SortArrayByParity Tester. 
* 
* @author JS 
* @since 04/28/2022 
* @version 1.0 
*/ 
public class SortArrayByParityTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: sortArrayByParity(int[] nums) 
* 
*/ 
@Test
public void testSortArrayByParity() throws Exception { 
//TODO: Test goes here...
    SortArrayByParity sortArrayByParity = new SortArrayByParity();
    System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(new int[]{3, 1, 2, 4})));
    System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(new int[]{3, 1, 5, 7})));
    System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(new int[]{2, 4, 6, 8})));
    System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(new int[]{2, 5, 6, 8,7})));
    System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(new int[]{0})));
}


} 
