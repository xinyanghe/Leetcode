class Solution {
    public void backtracking(List<String> list, int l, int r, 
                             String str, int n) {
        if (str.length() == n * 2)
            list.add(str);
        
        if (l < n)
            backtracking(list, l + 1, r, str + "(", n);
        if (r < l)
            backtracking(list, l, r + 1, str + ")", n);
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtracking(list, 0, 0, "", n);
        return list;
    }
}
