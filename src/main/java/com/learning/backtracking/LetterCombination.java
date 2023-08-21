package com.learning.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombination {
    private List<String> ans = new ArrayList<>();
    Map<Integer, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return Collections.emptyList();

        char letter = 'a';
        for (int i = 2; i <= 9; i++) {
            if (i == 7 || i == 9) {
                List<Character> c = new ArrayList<>(4);
                c.add(letter++);
                c.add(letter++);
                c.add(letter++);
                c.add(letter++);
                map.put(i, c);
            } else {
                List<Character> c = new ArrayList<>(3);
                c.add(letter++);
                c.add(letter++);
                c.add(letter++);
                map.put(i, c);
            }
        }

        combine(digits, 0, new LinkedList<>());
        return ans;
    }

    public void combine(String digits, int digitIdx, List<Character> letter) {
        if (letter.size() == digits.length()) {
            String l = letter.stream().map(String::valueOf)
                    .collect(Collectors.joining());
            ans.add(l);
            return;
        }
        if (digitIdx > digits.length()) return;

        int digit = (char) (digits.charAt(digitIdx) - '0');

        List<Character> arr = map.get(digit);

        for (int i = 0; i < arr.size(); i++) {
            letter.add(arr.get(i));
            combine(digits, digitIdx + 1, letter);
            letter.remove(letter.size() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";

        LetterCombination letterCombination = new LetterCombination();
        List<String> a = letterCombination.letterCombinations(digits);

        System.out.println(a);
    }
}
