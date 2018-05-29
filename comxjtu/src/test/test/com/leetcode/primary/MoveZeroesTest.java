package test.com.leetcode.primary; 

import com.leetcode.primary.MoveZeroes;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MoveZeroes Tester. 
* 
* @author <Authors name> 
* @since <pre>ÎåÔÂ 29, 2018</pre> 
* @version 1.0 
*/ 
public class MoveZeroesTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: moveZeroes(int[] nums) 
* 
*/ 
@Test
public void testMoveZeroes() throws Exception { 
//TODO: Test goes here...
    MoveZeroes mz = new MoveZeroes();
    int[] nums = new int[]{0,1,0,3,12};
    mz.moveZeroes(nums);
    for (int i = 0; i < nums.length; i++) {
        System.out.print(nums[i]);
    }
} 


} 
