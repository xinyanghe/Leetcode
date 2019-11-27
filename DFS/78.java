class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null)
            return results;
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    //Recurssion Definition
    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> results){
        //Recurssion Exit
        if(index == nums.length){
            results.add(new ArrayList<Integer>(subset));
            return;
        }
        
        //Recurssion divide
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, results);
        
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, results);
        
    }
}
