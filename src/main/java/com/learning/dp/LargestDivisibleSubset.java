package com.learning.dp;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Sort the array of numbers
        Arrays.sort(nums);

        // Length of the nums array
        int length = nums.length;

        // Array to store the size of the largest divisible subset
        // that ends with nums[i]
        int[] dp = new int[length];

        // Initialize all values in dp to 1
        Arrays.fill(dp, 1);

        // Variable to track the index of the largest element of the subset
        int maxIndex = 0;

        // Dynamic programming to fill the dp array
        for (int i = 1; i < length; ++i) {
            for (int j = 0; j < i; ++j) {
                // If nums[i] is divisible by nums[j], update dp[i]
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Update maxIndex if a larger subset is found
            if (dp[maxIndex] < dp[i]) {
                maxIndex = i;
            }
        }

        // Size of the largest divisible subset
        int subsetSize = dp[maxIndex];

        // List to store the largest divisible subset
        List<Integer> result = new ArrayList<>();

        // Construct the result list by going backwards from maxIndex
        for (int i = maxIndex; subsetSize > 0; --i) {
            if (nums[maxIndex] % nums[i] == 0 && dp[i] == subsetSize) {
                result.add(nums[i]);
                maxIndex = i;
                --subsetSize;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,8};

        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        List<Integer> ans = largestDivisibleSubset.largestDivisibleSubset(nums);
        System.out.println(ans);
    }
}
