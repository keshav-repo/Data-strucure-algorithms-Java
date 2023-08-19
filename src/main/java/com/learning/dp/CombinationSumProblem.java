package com.learning.dp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumProblem {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tmp = new ArrayList<>();
        helper(candidates, target, 0, 0, tmp);
        return ans;
    }

    public void helper(int[] candidates, int target, int idx, int currSum, List<Integer> tmp) {
        if (currSum > target)
            return;
        if (currSum == target) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (idx > (candidates.length - 1)) {
            return;
        }

        // include
        currSum += candidates[idx];
        tmp.add(candidates[idx]);
        helper(candidates, target, idx, currSum, tmp);
        currSum -= candidates[idx];
        tmp.remove(tmp.size() - 1);

        // exclusion
        helper(candidates, target, idx + 1, currSum, tmp);
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;

        CombinationSumProblem combinationSum = new CombinationSumProblem();
        List<List<Integer>> ans = combinationSum.combinationSum(candidates, target);
        System.out.println(ans);
    }
}
