package com.learning.array;

public class JumpGameII {
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        JumpGameII jumpGameII = new JumpGameII();
        int ans = jumpGameII.jump(nums);
        System.out.println(ans);
    }
}
