class demo {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    ans = dfs(board, word, i, j, 0, used);
                }
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int k, boolean[][] used) {
        if (k == word.length() - 1) {
            return true;
        }
        System.out.println(r+" "+c+" "+board[r][c]);
        int[][] nums = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        boolean result=false;
        for (int i = 0; i < nums.length; i++) {
            int r2 = r + nums[i][0];
            int c2 = c + nums[i][1];
            if (0 <= r2 && r2 < board.length && 0 <= c2 && c2 < board[0].length) {
                if (word.charAt(k + 1) == board[r2][c2] && !used[r2][c2]) {
                    used[r][c] = true;
                    result = dfs(board, word, r2, c2, k + 1, used);
                    used[r][c] = false;
                }
                if(result){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        demo s = new demo();
        char[][] c = new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
        System.out.println(s.exist(c, "AAB"));
    }
}
// CAA
// AAA
// BCD