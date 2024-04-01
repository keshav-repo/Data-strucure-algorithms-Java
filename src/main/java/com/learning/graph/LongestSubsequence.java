package com.learning.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LongestSubsequence {
    public static int longestConsecutive(int[] nums) {
        //base case
        if (nums.length <= 1) {
            return nums.length;
        }
        //declare a max varaibale
        int max = 1;
        Map<Integer, Integer> longest = new HashMap<Integer, Integer>();
        for (int n : nums) {
            longest.put(n, null);
        }
        //Run a loop to store the maximum value in the max varibale
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dfs(nums[i], longest));
        }

        return max;
    }
    //Run a dfs across every consecutive values
    private static int dfs(int start, Map<Integer, Integer> longest) {
        if (!longest.containsKey(start)) {
            return 0;
        }
        //check if the values are present in the map before hand
        if (longest.get(start) != null) {
            return longest.get(start);
        }
        //store the values in the currentlongest variable
        int currentLongest = 1 + dfs(start + 1, longest);

        longest.put(start, currentLongest);

        return currentLongest;
    }

    // Driver Code
    public static void main(String args[])
            throws IOException
    {
        //declare a array
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int n = arr.length;
        System.out.println(
                "Length of the Longest consecutive subsequence is "
                        + longestConsecutive(arr));
    }
}
