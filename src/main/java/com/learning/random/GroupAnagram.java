package com.learning.random;

import java.util.Arrays;
import java.util.List;
import java.util.*;

public class GroupAnagram {
    public static List<List<String>> groupAnagram(String[] arr) {
        Map<String, List<String>> res = new HashMap<>();
        char[] ch = new char[26];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(ch, '\u0000');
            for (char c : arr[i].toCharArray()) {
                if (Character.isUpperCase(c)) {
                    int diff = c - 'A';
                    ch[diff]++;
                } else if (Character.isLowerCase(c)) {
                    int diff = c - 'a';
                    ch[diff]++;
                }
            }
            String key = String.valueOf(ch);
            List<String> angrms = res.getOrDefault(key, new ArrayList<>());
            angrms.add(arr[i]);
            res.put(key, angrms);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: res.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"Eat", "tea", "tan", "ate", "silent", "nat", "bat", "listen", "debit card", "bad credit"};
        List<List<String>> ans = groupAnagram(strs);
        System.out.println(ans);
    }
}
