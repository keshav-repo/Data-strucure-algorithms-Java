package com.learning.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWord {

    public static String longestWord(String[] words) {
        Map<String, Boolean> wordPresent = new HashMap<>();
        for (String word : words) {
            wordPresent.put(word, true);
        }

        List<String> wordsFulfillingCondition = new ArrayList<>();
        for (String word : words) {
            boolean conditionMatching = true;
            for (int i = 1; i < word.length(); i++) {
                String subWord = word.substring(0, i);
                if (!wordPresent.containsKey(subWord)) {
                    conditionMatching = false;
                    break;
                }
            }
            if (conditionMatching) {
                wordsFulfillingCondition.add(word);
            }
        }
        int longestLen = Integer.MIN_VALUE;
        String res = "";
        for (String w : wordsFulfillingCondition) {
            if (w.length() > longestLen) {
                longestLen = w.length();
                res = w;
            } else if (w.length() == longestLen) {
                res = checkLexo(w, res);
            }
        }
        return res;
    }

    public static String checkLexo(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int x = a.length ;
        int y = b.length;
        int i = 0, j = 0;
        while (i < x || j < y) {
            int diff = a[i] - b[j];
            if (diff > 0)
                return s2;
            else if (diff < 0)
                return s1;
            i++; j++;
        }
        if (i != x) {
            return s2;
        }
        if (j != y)
            return s1;
        return s1;
    }

    public static int findVal(String s) {
        int val = 0;
        for (char c : s.toCharArray()) {
            val += c - 'a';
        }
        return val;
    }

    public static void main(String[] args) {
        // String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        //String[] words = {"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};

        String[] words = {"ts","e","x","pbhj","opto","xhigy","erikz","pbh","opt","erikzb","eri","erik","xlye","xhig","optoj","optoje","xly","pb","xhi","x","o"};

        String ans = longestWord(words);

        System.out.println(ans);


    }
}
