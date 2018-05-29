package test.com.leetcode.primary;

import com.leetcode.primary.Rotate;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Rotate Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 29, 2018</pre>
 */
public class RotateTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: rotate(int[] nums, int k)
     */
    @Test
    public void testRotate() throws Exception {
//TODO: Test goes here...
        Rotate r = new Rotate();
        r.rotate(new int[]{1,2,3,4,5,6,7},3);
        r.rotate(new int[]{-1,-100,3,99},2);
        r.rotate(new int[]{},3);
        r.rotate(new int[]{1,2,3},-1);
    }


} 
