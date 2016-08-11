package edu.zju.elliottqian.array;

/**
 * Created by QianWei on 2016/8/11.
 *
 * OK
 */
public class S004 {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4, 5};
        Solution_004 s = new Solution_004();
        double x = s.findMedianSortedArrays(a, b);
        System.out.println(x);
    }
}


class Solution_004{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

//        System.out.println(l1);
//        System.out.println(l2);

        int middle = 0;
        boolean two = false;
        if ((l1 + l2) % 2 == 0) {
            middle = (l1 + l2) / 2 - 1;
            two = true;
        } else {
            middle = (l1 + l2) / 2;
        }


        if (l1 ==0) {
            if(two){
                return (nums2[middle] + nums2[middle + 1]) / 2.0;
            }else{
                return nums2[middle];
            }
        }else if (l2 == 0) {
            if(two){
                return (nums1[middle] + nums1[middle + 1]) / 2.0;
            }else{
                return nums1[middle];
            }
        }


//        System.out.println(two);
//        System.out.print("middle: ");
//        System.out.println(middle);

        int[] stack = new int[middle + 2];


        int index_1 = 0;
        int index_2 = 0;
        // index 的关系
        int true_index = -1;
        int index_location = 0;
        while (true_index < middle + 1) {

            true_index ++;
            int temp_1 = index_1;
            int temp_2 = index_2;

            if (temp_1 < l1 && temp_2 < l2) {
//                System.out.println("jinru");
                if (nums1[temp_1] < nums2[temp_2]) {
                    stack[true_index] = nums1[temp_1];
                    index_1++;

                }else {
                    stack[true_index] = nums2[temp_2];
                    index_2 ++;
                }
            }else if (temp_1 >= l1) {
                stack[true_index] = nums2[temp_2];
                index_2 ++;
            }else if(temp_2 >= l2) {
                stack[true_index] = nums1[temp_1];
                index_1++;
            }

//            System.out.print("true_index:  ");
//            System.out.println(true_index);
//
//            System.out.println(index_1);
//            System.out.println(index_2);
//            System.out.println("---------------------");




        }


        if(two){
            return (stack[true_index] + stack[true_index - 1]) / 2.0;
        }else{
            return stack[true_index - 1];
        }
    }
}