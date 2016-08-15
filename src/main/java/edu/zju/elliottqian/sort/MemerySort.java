package edu.zju.elliottqian.sort;

/**
 * Created by hzqianwei on 2016/8/15.
 *
 */
public class MemerySort {

    public static void main(String[] args) {
        MemerySort m = new MemerySort();
        int[] a = {1, 3, 5, 7, 10};
        int[] b = {2, 4, 5, 8, 11};

        int[] x = m.MemeryArray(a, b);

        for (int i = 0; i < x.length; ++ i) {
            System.out.println(x[i]);
        }
    }


    public int[] MemeryArray(int[] a, int[] b) {

        int a_l = a.length;
        int b_l = b.length;

        int[] c = new int[a_l + b_l];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a_l && j < b_l) {
            if (a[i] < b[j]) {
                c[k ++] = a[i ++];
            } else {
                c[k ++] = b[j ++];
            }
        }

        while (i < a_l) {
            c[k ++] = a[i ++];
        }

        while (j < b_l) {
            c[k ++] = b[j ++];
        }

        return c;
    }
}
