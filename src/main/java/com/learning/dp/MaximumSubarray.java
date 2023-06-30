package com.learning.dp;

public class MaximumSubarray {
    public static int maxSubarraySum(int[] a){
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    public static int maxSubarraySum2(int[] a){
        int localMax = 0;
        int globalMax =Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            localMax = Math.max(a[i], a[i]+localMax);
            if(localMax > globalMax  ){
                 globalMax = localMax;
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] nums = {-2, -1,-3};

        System.out.println(maxSubarraySum2(nums));
    }
}
