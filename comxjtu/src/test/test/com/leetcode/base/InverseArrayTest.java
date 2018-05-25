package test.com.leetcode.base; 

import com.leetcode.base.InverseArray;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* InverseArray Tester. 
* 
* @author <Authors name> 
* @since <pre>ÎåÔÂ 25, 2018</pre> 
* @version 1.0 
*/ 
public class InverseArrayTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: inverseArr(int[] arr) 
* 
*/ 
@Test
public void testInverseArr() throws Exception { 
//TODO: Test goes here...
    int[] arr1 = new int[]{1,2,3,4,5};
    int[] arr2 = new int[]{1,2,3,4,5,6};
    arr1 = new InverseArray().inverseArr(arr1);
    arr2=  new InverseArray().inverseArr(arr2);
    for (int i = 0; i < arr1.length; i++) {
        System.out.print(arr1[i]);
    }
    System.out.println("");
    for (int i = 0; i < arr2.length; i++) {
        System.out.print(arr2[i]);
    }
}


} 
