// 普通DP
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

//recursion DP
class Solution {
    private int n;
    private int dp(int i, int[] dp) {
        if (i < 0) return 0;
        if (i == 0) return 1;
        if (dp[i] > 0) return dp[i];
        dp[i] = dp(i - 1, dp) + dp(i - 2, dp);
        return dp[i];
    }
    public int climbStairs(int n) {
        this.n = n;
        int[] dp = new int[n + 1];
        return dp(n, dp);
    }
}
