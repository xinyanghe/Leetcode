class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int res = 0;
        for (int i = 0; i < s.length(); i ++) {
            res += oddPal(s, i); //注意i是index不是value
        }
        for (int i = 0; i < s.length() - 1; i ++) {
            res += evenPal(s, i, i + 1); //注意i是index不是value
        }
        return res;
    }
    
    private int evenPal(String s, int l, int r) {
        int count = 0;
        int w = 0;
        while (l - w >= 0 && r + w < s.length()) {
            if (s.charAt(l - w) == s.charAt(r + w)) {
                count ++;
            }
            else {
                w = 0;
                break;
            }
                
            w ++;
        }
        return count;
    }
    
    private int oddPal(String s, int mid) {
        int count = 1;
        int w = 1;
        while (mid - w >= 0 && mid + w < s.length()) {
            if (s.charAt(mid - w) == s.charAt(mid + w)) {
                count ++;
            }
            else {
                w = 1;
                break;
            }
            w ++;
        }
        return count;
    }
}
