class Solution {
    private int rot(int[][] g, int i, int j, int d) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] != 1) 
            return 0;
        g[i][j] = d + 3;
        return 1;
    }
    
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int fresh = 0, d = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) 
                    fresh++;
            }    
        }
        
        for (int old = fresh; fresh > 0; old = fresh, d++) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == d + 2) {
                        fresh -= rot(grid, i + 1, j, d) + rot(grid, i - 1, j, d) + rot(grid, i, j - 1, d) + rot(grid, i, j + 1, d);
                    }
                }
            }
            if (fresh == old) return -1;
        }
        return d;
    }
}
