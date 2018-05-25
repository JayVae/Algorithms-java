package test.coom.xjtu.ch2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * SelectionSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since
 */
public class SelectionSortTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sort(Comparable[] a)
     */
    @Test
    public void testSort() throws Exception {
        int[] a = new int[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(100);
            System.out.println(a[i]);
        }

//TODO: Test goes here... 
    }


} 
