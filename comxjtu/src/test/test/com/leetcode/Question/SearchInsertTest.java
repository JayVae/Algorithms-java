package test.com.leetcode.Question;

import com.leetcode.Question.SearchInsert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * SearchInsert Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 28, 2018</pre>
 */
public class SearchInsertTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: searchInsert(int[] nums, int target)
     */
    @Test
    public void testSearchInsert() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: binarySearch(int[] nums, int target)
     */
    @Test
    public void testBinarySearch() throws Exception {
//TODO: Test goes here...
        SearchInsert si = new SearchInsert();
        System.out.println(si.searchInsert(new int[]{1,3,5,6},5));
        System.out.println(si.searchInsert(new int[]{1,3,5,6},2));
        System.out.println(si.searchInsert(new int[]{1,3,5,6},7));
        System.out.println(si.searchInsert(new int[]{1,3,5,6},0));
    }


} 
