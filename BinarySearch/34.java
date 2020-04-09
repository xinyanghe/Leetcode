class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int start = -1, end = -1;
        int []res = new int[2];
        
        if (n == 1) {
            if (nums[0] == target) 
                return new int[]{0, 0};
            else 
                return new int[]{-1, -1};
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else if (nums[mid] > target) {
                r = mid - 1;
            }
            else {
                start = mid;
                end = mid;
                while (start >= 0 && nums[start] == nums[mid]) {
                    start --;
                }
                start ++;
                while (end < n && nums[end] == nums[mid]) {
                    end ++;
                }
                end --;
                break;
            }
        }
        
        res[0] = start == -1 ? -1 : start;
        res[1] = end == -1 ? -1 : end;
        return res;
    }
}
