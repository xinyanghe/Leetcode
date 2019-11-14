
class Solution {
    public void sortColors(int[] nums) {
        int pl = 0, cur = 0;
        int pr = nums.length - 1;
        while(cur <= pr){
            if(nums[cur] == 0){
                int tmp = nums[pl];
                nums[pl] = nums[cur];
                nums[cur] = tmp;
                pl++;
                cur++;
            }
            else if(nums[cur] == 2){ //Notice else
                int tmp = nums[pr];
                nums[pr] = nums[cur];
                nums[cur] = tmp;
                pr--;
            }
            else{
                cur++;
            }          
        }
    }
}
