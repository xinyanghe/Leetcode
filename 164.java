class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int[] diff = new int[nums.length - 1];
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
            max = Math.max(max, diff[i]);
        }
        return max;
    }
}
