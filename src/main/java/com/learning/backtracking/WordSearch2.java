package com.learning.backtracking;

class WordSearch2 {
    private boolean visited[][];

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean found = dfs(board, i + 1, j, index + 1, word)
                || dfs(board, i - 1, j, index + 1, word)
                || dfs(board, i, j + 1, index + 1, word)
                || dfs(board, i, j - 1, index + 1, word);

        visited[i][j] = false;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCB";

        WordSearch2 ws = new WordSearch2();
        boolean res = ws.exist(board, word);
        System.out.println(res);
    }
}