package test.com.leetcode.Question;

import com.leetcode.Question.RemoveDuplicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * RemoveDuplicate Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 28, 2018</pre>
 */
public class RemoveDuplicateTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: removeDuplicates(int[] nums)
     */
    @Test
    public void testRemoveDuplicates() throws Exception {
//TODO: Test goes here...
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicate rd = new RemoveDuplicate();
        System.out.println("size"+rd.removeDuplicates(nums));
    }


} 
