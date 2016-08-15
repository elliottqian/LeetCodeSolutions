package edu.zju.elliottqian.sort;

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;

/**
 * Created by hzqianwei on 2016/8/15.
 *
 */
public class QuickSort {


    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] a = {2, 1, 5, 3, 8, 2, 4, 5, 8, 11};
        q.quickSort(a, 0, a.length);


        for (int i = 0; i < a.length; ++ i) {
            System.out.println(a[i]);
        }

    }

    /**
     *
     1
     2
     2
     3
     4
     5
     5
     8
     8
     11
     * @param a
     * @param first
     * @param last
     */

    public void quickSort(int[] a, int first, int last) {
        if (last - first > 1) {
            int rule = a[first];
            int empty_index = first;
            int i = first + 1;
            int j = last - 1;
            boolean right = true;

            while (i <= j) {                 //这里是等号  不然跳不出循环
                if (right){
                    if (a[j] < rule) {
                        a[empty_index] = a[j];
                        empty_index = j;
                        right = false;
                    }
                    j --;
                }else{
                    if (a[i] > rule) {
                        a[empty_index] = a[i];
                        empty_index = i;
                        right = true;
                    }
                    i ++;
                }
            }
            a[empty_index] = rule;
            quickSort(a, first, empty_index);
            quickSort(a, empty_index + 1, last);   // 这一步是index + 1  不然会跳不出循环的
        }
    }

}
