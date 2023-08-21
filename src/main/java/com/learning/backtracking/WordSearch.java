package com.learning.backtracking;

import java.util.Arrays;

public class WordSearch {

    boolean search(char[][] board, int x, int y, char[] arr, int idx, boolean visited[][]) {

        if ( idx >= arr.length || x >= board.length || y >= board.length || y < 0 && visited[x][y] == true) return false;

        System.out.println(board[x][y] + " " + idx);
        visited[x][y] = true;

        if (arr[idx] == board[x][y] && idx == arr.length-1)
            return true;
        else if (arr[idx] == board[x][y]) {
            idx++;
        }
        else if(arr[idx] != board[x][y])
            return false;

            return search(board, x + 1, y, arr, idx, visited)
                || search(board, x, y + 1, arr, idx, visited)
                || search(board, x, y - 1, arr, idx, visited);
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCB";

//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";

        WordSearch wordSearch = new WordSearch();
        boolean visited[][] = new boolean[board.length][];
        for(int i=0; i<visited.length; i++){
            visited[i] = new boolean[board.length];
            Arrays.fill(visited[i], false);
        }

        boolean wordFound = wordSearch.search(board, 0, 0, word.toCharArray(), 0, visited);

        System.out.println(wordFound);
    }
}
