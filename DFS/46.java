class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], res, new ArrayList());
        return res;
    }
    
    private void dfs(int[] nums, 
                     boolean[] visited, 
                     List<List<Integer>> res, 
                     ArrayList<Integer> subRes) {
        
        if(nums.length == subRes.size()) { //注意出口条件
            res.add(new ArrayList(subRes));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            subRes.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, res, subRes);
            visited[i] = false;
            subRes.remove(subRes.size() - 1);
        }
    }
}
