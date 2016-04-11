package edu.zju.elliottqian.Math;

/**
 * Created by ElliottQian on 2016.04.09.
 *
 * https://leetcode.com/problems/power-of-three/
 *
 * 看一个数是不是3的次方
 */

public class S326 {
    public static void main(String[] args){
        Solution_326 solution_326 = new Solution_326();
        System.out.println(solution_326.isPowerOfThree(-3));
    }
}

class Solution_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        double x = Math.log(n) / Math.log(3);
        System.out.println(Math.log(n));
        System.out.println(x);

        if (x % 1 >= 0.00000000001 && x % 1 <= 0.99999999999)
            return false;
        return true;
    }
}
