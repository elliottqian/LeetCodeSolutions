package edu.zju.elliottqian.Math;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by QianWei on 2016/8/11.
 * https://leetcode.com/problems/3sum/
 *
 *
 */
public class S015 {
    public static void main(String[] args){
    }
}


class So_015{
    public List<List<Integer>> threeSum(int[] nums) {

        int l = nums.length;

        Set<Integer> s = new HashSet<Integer>();
        for (int index = 0; index < l; ++index) {
            s.add(nums[index]);
        }

        Arrays.sort(nums);
        for (int index = 0; index < l; ++index) {
            System.out.println(nums[index]);
        }

        for (int index = 0; index < l - 1; ++index) {
            for (int j = index + 1; j < l; ++j) {

            }
        }


        return null;
    }
}