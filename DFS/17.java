class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    private void dfs(List<String> res, String digits, int index, String subres) { //注意变量声明以及index与value的转换 很容易搞乱
        if(index == digits.length()) {
            res.add(subres);
            return;
        }
        
        String letter = KEYS[(digits.charAt(index) - '0')];
        for (int i = 0; i < letter.length(); i++) {
            dfs(res, digits, index + 1, subres + letter.charAt(i));
        }
            
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        dfs(res, digits, 0, "");
        return res;
    }
}
