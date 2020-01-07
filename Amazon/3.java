class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> sub = new HashSet<>();
        int n = s.length();
        int count = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (!sub.contains(s.charAt(i))) {
                sub.add(s.charAt(i++));
                count = Math.max(count, i - j);//Notice:不能在if else里用count++和--，因为count需要取最大值
            } 
            else {
                sub.remove(s.charAt(j++));
            }
        }
        return count;
    }
}
