package com.company.alibaba;

/**
 * @Author: Jay
 * @Date: Created in 15:06 2018/8/21
 * @Modified By:
 */
import java.util.Scanner;

/**
 *     首先一定需要一个点集（Point[ ]）
 其次，注意本题中需要最终回到原点，否则直接使用贪心算法每次走最短即可。所以，想到一个比较朴素的方法DFS回溯。
 具体过程，有疑惑的时候就debug一遍关注每一个细节，递归就不迷糊了。
 */

/**
 * DFS，BFS，包括其他递归方法，保证其完整正确性首先要具有递归出口；
 * 其次，要考虑递归过程中是否携带 “状态记录”，若携带应注意记录的维护（自主维护还是递归栈“自己维护”）。
 * 由此引出一个，编程中的高效思想，即尽可能地不要直接使用形参。提倡方法内将参数进行拷贝，如此有利于
 * 状态与递归层次的对应关系（eg：下面代码中count+1优于count++，后者在回溯时需要--count）；
 * 当然，这不是一个“死规矩”，一些全局状态就需要我们在回溯的时候小心维护————恢复现场。其实操作系统本身
 * 也是如此工作的，保留现场出现在指令中断、函数调用等多种场合。
 */
public class Main {
    static final Point START = new Point(0,0);
    static int minpath = Integer.MAX_VALUE;

    public static int calculate(Point start, Point[] points, int sum, int count){
        if(count == points.length){
            minpath = Math.min(minpath, sum +start.getLength(START));
            return minpath;
        }
        for(int i = 0; i<points.length; i++){
            if(points[i].visited == false){
                sum += points[i].getLength(start);
                if(sum < minpath){
                    points[i].visited = true;
                    calculate(points[i], points, sum, count+1);
                }
                sum -= points[i].getLength(start);
                points[i].visited = false;
            }
        }
        return minpath;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int pnum = Integer.parseInt(input.nextLine().trim());

        /**构建点集*/
        Point[] points = new Point[pnum];
        for(int i = 0; i<pnum; i++){
            String[] locations = input.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int min = calculate(START, points, 0, 0);
        System.out.println(min);
    }
}

class Point{
    int px;
    int py;
    boolean visited;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;
        this.visited = false;
    }

    public int getLength(Point p){
        return Math.abs(px - p.px) + Math.abs(py - p.py);
    }
}
