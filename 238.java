//从左乘到i - 1， 再从右乘到i + 1
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length - 1;
        int[] ans = new int[n + 1];
        ans[0] = 1;
        for (int i = 1; i <= n; i++){
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int R = 1;
        for (int i = n; i >= 0; i--){
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        return ans;
    }
}
