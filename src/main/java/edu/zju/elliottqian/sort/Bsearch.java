package edu.zju.elliottqian.sort;

/**
 * Created by hzqianwei on 2016/8/15.
 *
 */
public class Bsearch {

    public static void main(String[] args) {
        int[] x = {1, 2 ,2 ,3 ,4 ,5 ,5 ,8 ,8 ,11};
        Bsearch b = new Bsearch();
        System.out.print(b.bSearch(x, 0, x.length, 11));
    }

    public int bSearch(int[] a, int first, int last, int targer) {
        if (last - first <= 0)
            return -1;
        int middle = (first + last) / 2;
        if (targer == a[middle])
            return middle;
        else if (targer < a[middle]) {
            return bSearch(a, first, middle, targer);
        } else {
            return bSearch(a, middle + 1, last, targer);
        }

    }
}
