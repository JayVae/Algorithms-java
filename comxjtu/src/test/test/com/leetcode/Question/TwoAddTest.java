package test.com.leetcode.Question;

import com.leetcode.Question.TwoAdd;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* TwoAdd Tester. 
* 
* @author <Authors name> 
* @since <pre>ÎåÔÂ 25, 2018</pre> 
* @version 1.0 
*/ 
public class TwoAddTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addTwoNumbers(ListNode l1, ListNode l2) 
* 
*/ 
@Test
public void testAddTwoNumbers() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: size(ListNode l) 
* 
*/ 
@Test
public void testSize() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: trans(int k) 
* 
*/ 
@Test
public void testTrans() throws Exception {
    System.out.println(Long.MAX_VALUE);
    System.out.println(Integer.MAX_VALUE);
    TwoAdd ttt=new TwoAdd();
    System.out.println("first");
    TwoAdd.ListNode rs1 = ttt.trans(11111111111l);
    System.out.println("second");
    TwoAdd.ListNode rs2 = ttt.trans(11111111111l);
    ttt.addTwoNumbers(rs1,rs2);

//TODO: Test goes here...
//    System.out.println(Math.pow(10,2));
} 


} 
