//Use two same function to process the part which before delete and after

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return subPalin(s, left + 1, right) || subPalin(s, left, right - 1);
            }
            left++;
            right--;
        }
            return true;
    }
    
    public boolean subPalin(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
