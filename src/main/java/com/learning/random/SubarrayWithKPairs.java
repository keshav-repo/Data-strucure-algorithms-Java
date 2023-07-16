package com.learning.random;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithKPairs {

    public static int findSubarrayWithKPairs(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int start = 0;
        int pairs = 0;
        int subarrayCount = 0;

        for (int end = 0; end < nums.length; end++) {
            int num = nums[end];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            if (countMap.get(num) == 2) {
                pairs++;
            }

            while (pairs >= k) {
                int leftNum = nums[start];
                countMap.put(leftNum, countMap.get(leftNum) - 1);

                if (countMap.get(leftNum) == 1) {
                    pairs--;
                }

                if (pairs >= k) {
                    subarrayCount += nums.length - end;
                }

                start++;
            }
        }

        return subarrayCount;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 2, 0, 1};
        int k = 1;
        int subarrayCount = findSubarrayWithKPairs(nums, k);
        System.out.println("Number of subarrays with at least " + k + " pairs: " + subarrayCount);
    }
}
