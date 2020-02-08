//Iteration
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        int[] dp = new int[amount + 1];
        int sum = 1;//Notice: start from 1
        
        while(sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    if (min < 0 || temp < min)
                        min = temp;
                }
            }
            dp[sum] = min;
            sum ++;
        }
        return dp[amount];
    }
}

//Recurrsion
class Solution {
    private int dp(int[] coins, int amount, int[] count) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (count[amount - 1] != 0)
            return count[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dp(coins, amount - coin, count);
            if (res >= 0 && res < min)
                min = res + 1;
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }
    
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        return dp(coins, amount, new int[amount]);
    }
}
