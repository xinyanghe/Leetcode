class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums); //sort的目的是把相同的数排在一起
        dfs(nums, 
            new boolean[nums.length], 
            results, 
            new ArrayList<Integer>());
        return results; //记得return
    }
    
    private void dfs(int[] nums, 
                     boolean[] visited, 
                     List<List<Integer>> results, 
                     List<Integer> subRes) {
        if (nums.length == subRes.size()) {
            results.add(new ArrayList<>(subRes));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) 
                continue; //注意是continue不是return
            if (i > 0 && 
                nums[i] == nums[i - 1] && 
                !visited[i - 1]) //注意本判断条件
                continue;
            subRes.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, results, subRes);
            visited[i] = false;
            subRes.remove(subRes.size() - 1);
        }
            
    }
}
