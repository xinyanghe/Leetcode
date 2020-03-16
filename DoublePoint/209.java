class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    int res = nums.length + 1;
    int sum = 0;
    int i = 0, j = 0;
    while (j < nums.length) {
        sum += nums[j++];
        while (sum >= s) {
            res = Math.min(res, j - i);
            sum -= nums[i++];
        }
    }
    return res == nums.length + 1 ? 0 : res;

    }
}
