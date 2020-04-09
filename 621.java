class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] ch = new int[26];
        for (int t : tasks) {
            ch[t - 'A'] ++;
        }
        Arrays.sort(ch);
        int i = 25;
        while (i >= 0 && ch[i] == ch[25] ) {
            i --;
        }
        return Math.max(tasks.length, (n + 1) * (ch[25] - 1) + (25 - i));
    }
}
