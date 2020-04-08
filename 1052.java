class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int save = 0, max = 0, res = 0;
        for(int i = 0; i <= n - X; i ++) { //注意遍历长度，窗口 + 步数 = 数组长度 + 1
            for (int j = i; j < i + X; j ++) {
                if (grumpy[j] == 1) {
                    save += customers[j];
                }
            }
            max = Math.max(save, max);
            save = 0;
        }
        for (int i = 0; i < n; i ++) {
            if(grumpy[i] == 0) {
                res += customers[i];
            }
        }
        return res + max;
    }
}
