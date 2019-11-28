//[[],[1],[1,2],[1,2,2],[2],[2,2]]

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null)
            return results;
        
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }
    
    
    private void dfs (int[] nums,
                      int index,
                      List<Integer> subset,
                      List<List<Integer>> results){
        results.add(new ArrayList<Integer>(subset));
        
        for (int i = index; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && i > index) {
                continue;
            }
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
        
    }
}
