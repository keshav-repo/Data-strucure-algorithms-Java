package com.learning.dp;

import java.util.Arrays;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;

        int[] up = new int[n];
        int[] down = new int[n];

        Arrays.fill(up,1);
        Arrays.fill(down,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    up[i] = Math.max(1+down[j],up[i]);
                else if(nums[i]<nums[j])
                    down[i] = Math.max(1+up[j],down[i]);
            }
        }
        return Math.max(up[n-1],down[n-1]);
    }

    public static void main(String[] args) {
        int[] arr ={1, 2, 1} ; // {1,7,4,9,2,5};
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        int ans = wiggleSubsequence.wiggleMaxLength(arr);
        System.out.println(ans);
    }
}
