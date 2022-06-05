package com.leetcode.everyday;

import java.util.Arrays;
import java.util.Random;

/**
 * @author JS
 * @version 1.0
 * @date 2022/6/5 10:27
 * @description //478. 在圆内随机生成点
 * 这里实现的方法看似可行，但是分布并不是，所以还是采用拒绝采样的思路来做。
 * （拒绝采样的意思是说：我们在一个更大的范围内生成随机数，并拒绝掉那些不在题目给定范围内的随机数，
 * 此时保留下来的随机数都是在范围内的。为了在一个半径为 RR 的圆中生成均匀随机点，我们可以使用一个边长为 2R2R 的正方形覆盖住圆，
 * 并在正方形内生成均匀随机点，此时就只需要对于横坐标和纵坐标分别生成一个随机数即可。）
 */
public class RandomPoint {

    private double radius;
    private double x_center, y_center;

    public RandomPoint(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        Random random = new Random();
//        double x_left = x_center-radius, x_right = x_center+radius;
        double x_random =  x_center+random.nextDouble() * radius;
        double y_half = Math.sqrt(radius*radius- Math.pow(x_random-x_center,2));
//        double y_up = y_center+y_half, y_down=y_center-y_half;
        double y_random = y_center + random.nextDouble() *y_half;;
        return new double[]{x_random, y_random};
    }

    public static void main(String[] args) {
        RandomPoint randomPoint = new RandomPoint(1.0,0.0,0.0);
        System.out.println(Arrays.toString(randomPoint.randPoint()));
        System.out.println(Arrays.toString(randomPoint.randPoint()));
        System.out.println(Arrays.toString(randomPoint.randPoint()));
        System.out.println(Arrays.toString(randomPoint.randPoint()));
        System.out.println(Arrays.toString(randomPoint.randPoint()));
        System.out.println(Arrays.toString(randomPoint.randPoint()));

    }
}
