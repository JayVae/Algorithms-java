package com.leetcode.everyday; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/** 
* MaskPII Tester. 
* 
* @author JS 
* @since 04/01/2023 
* @version 1.0 
*/ 
@RunWith(Parameterized.class)
public class MaskPIITest {


    String expected = "";
    String input = "";

    @Parameterized.Parameters
    public static Collection<Object[]> t(){
        return Arrays.asList(new Object[][]{{"***-***-7890", "1(234)567-890"},{"+**-***-***-5678","86-(10)12345678"}});
    }

    public MaskPIITest(String expected, String input) {
        this.expected = expected;
        this.input = input;
    }

    /**
     *
     * Method: maskPII(String s)
     *
     */
    @Test
    public void testMaskPII() throws Exception {
        assertEquals(expected, new MaskPII().maskPII(input));
    }
    @Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 



/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 


} 
