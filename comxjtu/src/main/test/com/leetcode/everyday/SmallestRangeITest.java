package com.leetcode.everyday; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* SmallestRangeI Tester. 
* 
* @author JS 
* @since 04/30/2022 
* @version 1.0 
*/ 
public class SmallestRangeITest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: smallestRangeI(int[] nums, int k) 
* 
*/ 
@Test
public void testSmallestRangeI() throws Exception { 
//TODO: Test goes here...
    SmallestRangeI smallestRangeI = new SmallestRangeI();
    System.out.println(smallestRangeI.smallestRangeI(new int[]{1},0));
    System.out.println(smallestRangeI.smallestRangeI(new int[]{0,10},2));
    System.out.println(smallestRangeI.smallestRangeI(new int[]{1,3,6},3));
    System.out.println(smallestRangeI.smallestRangeI(new int[]{1,1,1},3));
}


} 
