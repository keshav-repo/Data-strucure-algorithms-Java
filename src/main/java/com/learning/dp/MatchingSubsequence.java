package com.learning.dp;

import java.util.HashMap;
import java.util.Map;

public class MatchingSubsequence {
    boolean issubsequence(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j))
                i++;
            j++;
        }
        return i == n;
    }

    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<String, Integer> wordMap = new HashMap<>();
        for(int i=0; i<words.length; i++){
            if(wordMap.containsKey(words[i])){
                int c = wordMap.get(words[i]);
                wordMap.put(words[i], ++c);
            }else {
                wordMap.put(words[i], 1);
            }
        }
        for(Map.Entry<String, Integer> entry: wordMap.entrySet()){
            if(issubsequence(entry.getKey(), s)){
                count += entry.getValue();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String[] arr = {"a","bb","adc","ace"};
        MatchingSubsequence subsequence = new MatchingSubsequence();
        int ans = subsequence.numMatchingSubseq(s1, arr);
        System.out.println(ans);
    }
}
