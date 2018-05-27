package test.com.leetcode.Question;

import com.leetcode.Question.ValidParentheses;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* ValidParentheses Tester. 
* 
* @author <Authors name> 
* @since <pre>ÎåÔÂ 27, 2018</pre> 
* @version 1.0 
*/ 
public class ValidParenthesesTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: isValid(String s) 
* 
*/ 
@Test
public void testIsValid() throws Exception { 
//TODO: Test goes here...
    String s ="{[]}";
    System.out.println(new ValidParentheses().isValid(s));
//    assert new ValidParentheses().isValid(s);

} 


} 
