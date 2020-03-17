class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) return 0; //Notice
        if (s.length() <= k) return s.length(); //Notice 题目是 at most k
        int[] ascii = new int[256];
        int i = 0, j = 0, res = 0, count = 0;
        while(j < s.length()) {
            //这个if要写在j++前面不然会溢出
            if (ascii[s.charAt(j)] == 0) {
                count ++;
            } 
            ascii[s.charAt(j)] += 1;
            j ++;
            //记录res
            if (count == k) {
                res = Math.max(res, j - i);
            }
            while (count > k) {
                ascii[s.charAt(i)] -= 1;
                //确认没了才可以count--
                if (ascii[s.charAt(i)] == 0)
                    count --;
                i ++;
            }  
        }
        //防止j - i不够k，res没记录下来的情况
        return res == 0 ? j - i : res;
    }
}
