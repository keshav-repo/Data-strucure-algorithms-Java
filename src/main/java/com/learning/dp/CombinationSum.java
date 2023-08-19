package com.learning.dp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> ls = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] c, int target) {
        cum(c, target, 0);
        return ans;
    }

    public void cum(int[] c, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int i = start; i < c.length; i++) {
            if (c[i] <= target) {
                ls.add(c[i]);
                cum(c, target - c[i], i);
                ls.remove(ls.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;

        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> ans =  combinationSum.combinationSum(candidates, target);
        System.out.println(ans);


    }
}