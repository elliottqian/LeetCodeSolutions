package edu.zju.elliottqian.line_struct;

import edu.zju.elliottqian.public_struct.Tree;
/**
 * Created by HIH-D-8227$ on 2016/7/6.
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class S215 {
    public static void main(String[] args){
        Soulution_215 s = new Soulution_215();
        int[] test = {3,2,1,5,6,4};

        s.getMaxNum(test, 6);
        System.out.print(test[0]);

    }
}

class Soulution_215{
    public int findKthLargest(int[] nums) {
        int[] newNum = new int[nums.length + 1];
        int length = nums.length;
        newNum[length] = length;
        return 0;
    }


    public int getMaxNum(int[] nums, int length) {
        adjustHeap(nums, length);
        int max = nums[0];
        nums[0] = nums[length - 1];
        length --;
        System.out.print(length);
        return max;
    }

    public void adjustHeap(int[] nums, int length) {
        int len = length;
        int lastIndex = len - 1;
        for(int i = (lastIndex - 1) / 2; i >=0; --i) {
            compareSons(nums, i, length);
        }

    }

    public void compareSons(int[] nums, int father, int length) {
        int left = father * 2 + 1;
        int right = father * 2 + 2;
        if (nums[father] <= nums[left]) {
            swap(nums, father, left);
        }
        if (right < length) {
            if (nums[father] <= nums[right]) {
                swap(nums, father, right);
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}