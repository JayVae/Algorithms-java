package test.com.leetcode.Question;

import com.leetcode.Question.TwoAdd2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* TwoAdd2 Tester. 
* 
* @author <Authors name> 
* @since <pre>ÎåÔÂ 25, 2018</pre> 
* @version 1.0 
*/ 
public class TwoAdd2Test { 

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
    TwoAdd2 ttt=new TwoAdd2();
    System.out.println("first");
    TwoAdd2.ListNode rs1 = ttt.trans(753865680);
    System.out.println("second");
    TwoAdd2.ListNode rs2 = ttt.trans(798580876);
    TwoAdd2.ListNode l = ttt.addTwoNumbers(rs1,rs2);
    ttt.show(l);

//TODO: Test goes here... 
} 


} 
