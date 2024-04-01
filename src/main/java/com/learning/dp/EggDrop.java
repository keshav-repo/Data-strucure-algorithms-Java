package com.learning.dp;

public class EggDrop {
    static int eggDrop(int n, int k) {
        if (k == 1 || k == 0)
            return k;
        if (n == 1)
            return k;
        int min = Integer.MAX_VALUE;
        int x, res;

        for (x = 1; x <= k; x++) {
            res = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
            if (res < min)
                min = res;
        }
        return min + 1;
    }

    public static void main(String args[]) {
        int eggCount = 2, floorCount = 10;
        System.out.print("Minimum number of "
                + "trials in worst case with " + eggCount
                + " eggs and " + floorCount + " floors is "
                + eggDrop(eggCount, floorCount));
    }
}
