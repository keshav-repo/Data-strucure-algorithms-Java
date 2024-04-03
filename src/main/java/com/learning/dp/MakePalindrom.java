package com.learning.dp;

import java.util.ArrayList;
import java.util.List;

public class MakePalindrom {
    // Variable that will hold frequency for each letter seen till index
    private int[][] occurances;

    // Method to initialize occurances
    private void calculateSeenAlphabets(String s) {
        int[][] occurances = new int[s.length()][26];
        occurances[0][s.charAt(0) - 'a'] = 1;

        for (int i = 1; i < s.length(); i++) {
            Character ch = s.charAt(i);

            // Copy character frequencies till seen till previous character
            for (int j = 0; j < 26; j++) {
                occurances[i][j] = occurances[i - 1][j];
            }

            // Increment the count of current character
            occurances[i][ch - 'a']++;
        }
        this.occurances = occurances;
    }

    private Boolean canBeMadePalindrome(int left, int right, int numberOfOperationsLimit) {
        int numberOfOdds = 0;
        if (left == 0) {
            for (int i = 0; i < 26; i++) {
                if (occurances[right][i] % 2 == 1) {
                    numberOfOdds++;
                }
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if ((occurances[right][i] - occurances[left - 1][i]) % 2 == 1) {
                    numberOfOdds++;
                }
            }
        }

        return numberOfOdds / 2 <= numberOfOperationsLimit;
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        calculateSeenAlphabets(s);

        for(int i=0; i<occurances.length; i++){
            for(int j=0; j<occurances[i].length; j++){
                System.out.print(occurances[i][j]+" ");
            }
            System.out.println("");
        }

        List<Boolean> results = new ArrayList();

        for (int i = 0; i < queries.length; i++) {
            results.add(canBeMadePalindrome(queries[i][0], queries[i][1], queries[i][2]));
        }
        return results;
    }

    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries  =  {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}, {3,4,1}};

        MakePalindrom makePalindrom = new MakePalindrom();
        List<Boolean> res = makePalindrom.canMakePaliQueries(s, queries);
        System.out.println(res);
    }
}
