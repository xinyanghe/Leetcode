//Not DP but so easy
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] sq = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    sq[i + 1][j + 1] = Math.min(Math.min(sq[i + 1][j], sq[i][j + 1]), sq[i][j]) + 1;
                    max = Math.max (max, sq[i + 1][j + 1]);
                }
            }
        }
        return max * max;
    }
}
