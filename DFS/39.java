class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) { 
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void dfs(int[] candidates, int target, List<List<Integer>> res,
                     ArrayList<Integer> canRes, int left) { // Left is to avoid repeat subsets
        if (target == 0) {
            res.add(new ArrayList<>(canRes));
            return;
        }  
        if (target < 0)
            return;
        
        for (int i = left; i < candidates.length; i++) {
            if (candidates[i] <= target) { // Notice <= not <
                canRes.add(candidates[i]);
                target -= candidates[i];
                dfs(candidates, target, res, canRes, i); // If change to i + 1, no repeat numbers
                canRes.remove(canRes.size() - 1);
                target += candidates[i];
            }
        }
    }
}
