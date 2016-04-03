package edu.zju.elliottqian.BinarySearch;

/**
 * Created by ElliottQian on 2016.04.03.
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * 优化: 两个2分查找可以合并成一个
 */
public class S74 {
    public static void main(String[] args){
        int[][] examples = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};

        Solution_74 solution_74 = new Solution_74();
//        int row1 = solution_74.findTheRow(examples , 1);
//        int row2 = solution_74.findTheRow(examples , 11);
        int row3 = solution_74.findTheRow(examples , 24);
//        System.out.println(row1);
//        System.out.println(row2);
        System.out.println(solution_74.searchMatrix(examples , 24));

    }
}

class Solution_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null ) return false;
        if (matrix.length == 0) return false;
        if (matrix[0] == null) return false;
        if (matrix[0].length == 0) return false;

        int m = matrix.length;      //行
        int n = matrix[0].length;   //列

        /**
         * 1,找到所属的行
         */
        int row = findTheRow(matrix, target);
        if (row == -1) return false;
        //System.out.println("row:" + row);

        /**
         * 2,找到所属的列
         */
        int[] list = matrix[row];
        return findTheColumn(list, target);
    }


    public boolean findTheColumn(int[] list, int target) {

        int length = list.length;
        int low = 0;
        int high= length - 1;

        while(low <= high){
            int middle = (low + high) / 2;
            if(list[middle] == target) {
                return true;
            }else if (target < list[middle]) {
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }

        return false;
    }

    public int findTheRow(int[][] matrix, int target){
        int m = matrix.length;      //行
        int n = matrix[0].length;   //列

        int start = 0;
        int end = m - 1;

        if (target < matrix[0][0])
            return -1;
        else if (target > matrix[m - 1][n - 1] )
            return -1;


        while(start <= end){
            int middle = (start + end) / 2;
            int right = matrix[middle][n - 1];
            int left = matrix[middle][0];
            //System.out.println(left + "!" + right);

            if(target <= right && target >= left) {
                return middle;
            }else if (target < left) {
                end = middle - 1;
            }else{
                start = middle + 1;
            }
            //System.out.println(start + "," + middle + "," + end);
        }

        return -1;
    }
}