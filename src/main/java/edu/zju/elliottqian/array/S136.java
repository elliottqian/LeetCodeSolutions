package edu.zju.elliottqian.array;

/**
 * Created by QianWei on 2016/8/17.
 *
 *
 * 异或运算和同或运算
 */
public class S136 {

    public static void main(String[] args){

    }


    public int singleNumber(int[] nums) {

        if (nums == null )
            return 0;
        if (nums.length == 0)
            return 0;
        int result = 0;

        for (int index = 0; index < nums.length; ++index) {
            result = result ^ nums[index];
        }
        return result;
    }

    public int newIndex(int index){
        return index + 4;
    }
}