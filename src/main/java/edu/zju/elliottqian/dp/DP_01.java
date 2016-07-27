package edu.zju.elliottqian.dp;

/**
 * Created by hzqianwei on 2016/7/27.
 * 最长子升序列的长度
 * {6,3,1,4,7,4,6,0,3,1,5,9,8,6,7}
 * 主要是状态方程
 */
public class DP_01 {

    public static void main(String[] args) {
        int[] arr = {6,3,1,4,7,4,6,0,3,1,5,9,8,6,7};
        int[] a = {5,3,4,8,6,7};
        System.out.println(DP_01.getResult(a));
    }

    /**
     * 复杂度:n^2
     * @param nums
     * @return
     */
    public static int getResult(int[] nums) {

        int len = nums.length;
        /**
         * 定义状态
         */
        int[] status = new int[len];
        status[0] = 1;

        for (int index = 1; index < len; ++index) {
            int tempMax = 1;
            for (int search = 0; search < index; ++search) {
                if (nums[search] < nums[index]) {
                    /**
                     * 这里是状态转移方程
                     */
                    if (tempMax < status[search] + 1) {
                        tempMax = status[search] + 1;
                    }
                }
            }
            status[index] = tempMax;
        }

        return status[len - 1];
    }

}
