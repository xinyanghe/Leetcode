class Solution {
    private int rot(int[][] g, int i, int j, int d) { //让g[i][j]周围四个的即将腐烂程度变成 3 + 天数，第0天g[i][j]是2，第一天周围将会变成3
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] != 1) return 0;
        g[i][j] = d + 3;
        return 1;
    }
    
    public int orangesRotting(int[][] grid) {
        int fresh = 0, d = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    fresh++;//新鲜果子数量
            }
        }
        for (int old = fresh; fresh > 0; d++, old = fresh){//更新新鲜果子数量和天数
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++){
                    if (grid[i][j] == d + 2)//如果果子已经烂了
                        fresh -= rot(grid, i - 1, j, d) + rot(grid, i, j - 1, d) + rot(grid, i + 1, j, d) + rot(grid, i, j + 1, d);//即将腐烂的个数
                    
                }
            }
            if (fresh == old) return -1;//新鲜果子数量不再下降，说明有隔离
        }
        return d;
    }
}
