package com.learning.backtracking;

import java.util.List;
import java.util.ArrayList;

class PermutationProblem {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }

    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        PermutationProblem pe = new PermutationProblem();
        System.out.println(pe.permute(nums));

    }
}