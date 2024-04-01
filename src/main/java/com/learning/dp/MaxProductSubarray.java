package com.learning.dp;

public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {

        int maxProduct = Integer.MIN_VALUE;
        int product = 1;
        Integer minNegativeMul = null;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                product = product * nums[i];
            } else if (nums[i] < 0) {
                minNegativeMul = minNegativeMul == null ? nums[i] : (minNegativeMul > nums[i]) ? nums[i] : minNegativeMul;
                product = product * nums[i];
            } else {
                // case when nums[i] ==0
                if (product > maxProduct) {
                    maxProduct = product;
                }
                if (product < 0) {
                    product = product / minNegativeMul;
                }
                product = 1;
            }
        }
        if (product > maxProduct) {
            maxProduct = product;
        }
        return maxProduct;

    }


    public static int maxProduct2(int[] nums) {

        int max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int temp = max;  // store the max because before updating min your max will already be updated

            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if (max > ans) {
                ans = max;
            }
        }
        return ans;
    }

    static int maxSubarrayProduct(int arr[]) {
        int n = arr.length;
        // max positive product
        // ending at the current position
        int max_ending_here = arr[0];

        // min negative product ending
        // at the current position
        int min_ending_here = arr[0];

        // Initialize overall max product
        int max_so_far = arr[0];

        for (int i = 1; i < n; i++) {
            int temp = Math.max(Math.max(arr[i], arr[i] * max_ending_here), arr[i] * min_ending_here);

            min_ending_here = Math.min(Math.min(arr[i], arr[i] * max_ending_here), arr[i] * min_ending_here);

            max_ending_here = temp;

            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }


    public static void main(String[] args) {
        int arr[] = {2, 2, 3, -2, 4};

        int ans = maxSubarrayProduct(arr);
        System.out.println(ans);
    }

}
