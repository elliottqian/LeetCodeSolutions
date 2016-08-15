package edu.zju.elliottqian.sort;

/**
 * Created by hzqianwei on 2016/8/15.
 *
 */
public class MemerySort {

    public static void main(String[] args) {
        MemerySort m = new MemerySort();
        int[] a = {2, 1, 5, 3, 8, 2, 4, 5, 8, 11};
        int[] b = {};

        int[] x = m.mergeSort(a, 0, a.length);

        for (int i = 0; i < x.length; ++ i) {
            System.out.println(x[i]);
        }
    }


    public int[] mergeSort(int[] array, int first, int last) {
        int middle = (last + first) / 2;
        if (last - first > 1) {
            System.out.println("--------------------------");
            System.out.println(first);
            System.out.println(last);
            System.out.println("--------------------------");
            mergeSort(array, first, middle);
            mergeSort(array, middle, last);
            mergeArray(array, first, middle, last);
        }
        return array;
    }


    public void mergeArray(int[] array, int first, int middle, int last) {
        //   0        1      2       3        4         5
        //   first                 middle                   last
        int i = first;
        int j = middle;
        int k = 0;

        int[] tmp = new int[last - first];

        while (i < middle && j < last) {
            if (array[i] < array[j]) {
                tmp[k ++] = array[i ++];
            } else {
                tmp[k ++] = array[j ++];
            }
        }

        while (i < middle) {
            tmp[k ++] = array[i ++];
        }

        while (j < last) {
            tmp[k ++] = array[j ++];
        }

        k = first;
        for (int index = 0; index < tmp.length; ++index) {
            array[k] = tmp[index];
            k ++;
        }

    }


    public int[] MegeArray(int[] a, int[] b) {

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
