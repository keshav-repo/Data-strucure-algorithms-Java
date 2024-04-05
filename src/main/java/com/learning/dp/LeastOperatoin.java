package com.learning.dp;

import java.util.*;

public class LeastOperatoin {
    private int base;
    private Map<Integer, Integer> memo = new HashMap<>();

    public int leastOpsExpressTarget(int x, int target) {
        this.base = x;
        return dfs(target);
    }

    private int dfs(int value) {
        // If the base is greater or equal to the value, we have two expressions:
        // 1) Using '+' base 'value' times: (x/x + x/x + ... + x/x)
        // 2) Using '-' once and '+' (base-value) times: (x - x/x - x/x - ...)
        if (base >= value) {
            return Math.min(value * 2 - 1, 2 * (base - value));
        }
        // If we have already computed the minimum operations for this value, return it
        if (memo.containsKey(value)) {
            return memo.get(value);
        }
        // Start with exponent 'k' at 2 because we have x^1 = x already
        int exponent = 2;

        // Calculate x^exponent while it's less than the 'value'
        long power = (long) base * base;
        while (power < value) {
            power *= base;
            ++exponent;
        }

        // The result is either by subtracting the value from the power of x found
        // Or by adding more to reach the power of x and then subtracting the target value from it
        int operations = exponent - 1 + dfs(value - (int) (power / base));

        // Check if we should also consider the case where the power exceeds the value
        if (power - value < value) {
            operations = Math.min(operations, exponent + dfs((int) power - value));
        }
        // Store the result in memoization map for future reference
        memo.put(value, operations);
        return operations;
    }

    public static void main(String[] args) {
        LeastOperatoin leastOperatoin = new LeastOperatoin();
        int ans =  leastOperatoin.leastOpsExpressTarget(5, 501);
        System.out.println(ans);
    }
}
