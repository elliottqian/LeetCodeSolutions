package edu.zju.elliottqian.BinarySearch;

/**
 * Created by hzqianwei on 2016/7/25.
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class S153 {
    public static void main(String[] args){
        int[] x = {8, 0, 1, 2, 4, 5, 6, 7};
        Solution_153 s = new Solution_153();
        s.findMin(x);
    }
}



class Solution_153 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int r = bs(nums, left, right);
        System.out.print(r);
        return 0;
    }

    public int bs(int[] nums, int left, int right) {
        System.out.println(left);
        System.out.println(right);
        System.out.println("-------------------------------");
        if(left + 1 < right) {

            int middle = (left + right) / 2;
            int newLeft;
            int newRight;

            int a = nums[left];
            int b = nums[middle];
            int c = nums[right];

            if (a < b && b < c){
                return nums[left];
            }

            if (nums[left] > nums[middle]) {
                System.out.println("left is big");
                newLeft = left;
                newRight = middle;
            }else {
                newLeft = middle;
                newRight = right;
            }
            return bs(nums, newLeft, newRight);
        } else if (left == right) {
            return nums[left];
        }else{
            if (nums[left] < nums[right]) {
                return nums[left];
            }else{
                return nums[right];
            }
        }
    }

}