package edu.zju.elliottqian.Sort;

/**
 * Created by QianWei on 2016/8/25.
 *
 */

public class BackTrack {

    int currentValue = 0;
    int bestValue = 0;

    public static void main(String[] args) {
        BackTrack bt = new BackTrack();
        bt.backtrack_2(0);
    }


//    W = (10, 8,5)
//    p = (5,5,1)
//    C = 16;
    int n = 3;

    int[] W = {8, 10, 5};
    int[] P = {5, 5, 1};
    int C = 16;

    int[] X = {0, 0, 0};

    /**
     * 回溯， 没有剪枝
     * @param i
     * 3层二叉树
     */
    public void backtrack(int i){
        if (i >= n) {
            System.out.print(X[0]);
            System.out.print(X[1]);
            System.out.println(X[2]);
        }else {
            int low = 0;
            int high = 1;
            for (int x = low; x <= high; ++x) {
                X[i] = x;
                backtrack(i + 1);
            } // for
        }
    }

    /**
     * 非递遍历
     */
    public void backtrack(){
        int i = 0;
        while(i >= 0) {
            if (i <= 2) {  // 当前节点存在子节点
                for (int x = 0; x <= 1; ++x) {
                    X[i] = x;
                    if (i == 2) {
                        System.out.print(X[0]);
                        System.out.print(X[1]);
                        System.out.println(X[2]);
                    } else {
                        i++;
                    }
                } // for
            } else
                i--;
        }
    }

    /**
     * 回溯， 并且剪枝
     * @param i
     */
    public void backtrack_2(int i){
        if (i >= n) {
            System.out.print(X[0]);
            System.out.print(X[1]);
            System.out.println(X[2]);
            currentValue = X[0] * P[0] + X[1] * P[1] + X[2] * P[2];
            if (currentValue > bestValue) {
                bestValue = currentValue;
            }
            System.out.print("currentValue:");
            System.out.println(currentValue);
            System.out.print("bestValue:");
            System.out.println(bestValue);
        }else {
            int low = 0;
            int high = 1;

            for (int x = low; x <= high; ++x) {
                X[i] = x;


                int W_ALL = 0;
//                System.out.println("currentLevel:" + String.valueOf(i));
                for (int level = 0; level <= i; ++level) {   // 剪枝步骤
                    W_ALL += X[level] * W[level];
//                    System.out.print(X[level]);
                }

//                System.out.println();
//                System.out.println("currentWeight:" + String.valueOf(W_ALL));
//                System.out.println("------------------");


                if (W_ALL <= C)  // 该节点的子节点有可行解
                    backtrack_2(i + 1);
            } // for
        }
    }


}
