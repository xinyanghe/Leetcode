//注意检查非数字字母情况

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        
        int front = 0;
        int end = s.length() - 1;
        
        while(front < end){
            while(front <= s.length() - 1 && !isValid(s.charAt(front)))
                front++;
            if(front == s.length())//Check ".,,,"
                return true;
            while(end >= 0 && !isValid(s.charAt(end)))
                end--;
            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end)))
                return false;
            end--;
            front++;
            
        }
        return true;
    }
    //Skip space
    private boolean isValid(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
