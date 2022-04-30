package com.leetcode.everyday; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* QuadTree Tester. 
* 
* @author JS 
* @since 04/29/2022 
* @version 1.0 
*/ 
public class QuadTreeTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: construct(int[][] grid) 
* 
*/ 
@Test
public void testConstruct() throws Exception { 
//TODO: Test goes here...
    QuadTree quadTree = new QuadTree();
    quadTree.outResult(quadTree.construct(new int[][]{{0,1},{1,0}}));
    quadTree.outResult(quadTree.construct(new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}}));
    quadTree.outResult(quadTree.construct(new int[][]{{1,1},{1,1}}));
    quadTree.outResult(quadTree.construct(new int[][]{{0}}));
    quadTree.outResult(quadTree.construct(new int[][]{{1,1,0,0},{1,1,0,0},{0,0,1,1},{0,0,1,1}}));
}

/** 
* 
* Method: outResult(Node root) 
* 
*/ 
@Test
public void testOutResult() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: constructChild(int[][] grid, int startX, int startY, int length) 
* 
*/ 
@Test
public void testConstructChild() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = QuadTree.getClass().getMethod("constructChild", int[][].class, int.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: levelOrder(Node root) 
* 
*/ 
@Test
public void testLevelOrder() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = QuadTree.getClass().getMethod("levelOrder", Node.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
