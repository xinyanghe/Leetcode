class Solution {
    public boolean dfs(char[][] board, String word, int idx,
                       int i, int j, boolean[][] visited) {
        if (idx == word.length())
            return true;
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || 
            visited[i][j] || board[i][j] != word.charAt(idx))
            return false;
        
        visited[i][j] = true;
        if (dfs(board, word, idx + 1, i + 1, j, visited) || dfs(board, word, idx + 1, i - 1, j, visited) ||
            dfs(board, word, idx + 1, i, j + 1, visited) || dfs(board, word, idx + 1, i, j - 1, visited))
            return true;
        visited[i][j] = false;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
