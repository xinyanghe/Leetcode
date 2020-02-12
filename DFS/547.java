class Solution {
    private void dfs(int[][] M, int i) {
        for (int j = 0; j < M.length; j ++) {
            if (M[i][j] == 1) {
                M[i][j] = M[j][i] = 0;
                dfs(M, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < M.length; i ++) {
            if(M[i][i] == 1) {
                dfs(M, i);
                count ++;
            }
        }
        return count;
    }
}
