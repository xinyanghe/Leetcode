class Solution {
    private void swapItem(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void swapList(int i, int j, int[] nums){
        while (i < j){
            swapItem(i, j, nums);
            i ++;
            j --;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) //注意特殊情况
            return;
        int i = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) { //继续注意特殊情况
            i--;
        }
        if (i != 0) { //特殊情况
            int j = n - 1;
            while (nums[j] <= nums[i - 1]) //注意i - 1
                j--;
            swapItem(i - 1, j, nums); //注意i - 1
        }
        swapList(i, n - 1, nums);
    }
}
