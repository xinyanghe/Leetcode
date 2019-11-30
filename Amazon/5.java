class Solution {
    private int subP(String s, int left, int right){
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right))
                break;
            len += left == right ? 1 : 2;
            left --;
            right ++;
        }
        return len;
    }
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        int start = 0, len = 0, longest = 0;
        for (int i = 0; i < s.length(); i ++) {
            len = subP(s, i, i);
            if (len > longest) { //Don't use Math.max because start will change with i
                longest = len;
                start = i - len / 2;
            }
            
            len = subP(s, i, i + 1);
            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }
        }
        return s.substring(start, start + longest);
    
    }
}
