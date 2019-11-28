
// [[1,2,3],[1,2],[1,3],[1],[2,3],[2],[3],[]]
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


//[[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null)
            return results;
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
            
    }
    
    private void dfs (int[] nums, 
                 int index,
                 List<Integer> subset,
                 List<List<Integer>> results){
        results.add(new ArrayList<Integer>(subset));
        for(int i = index; i < nums.length; i++){
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
        
    }
}
