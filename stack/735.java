//不知道该说啥 回头得再做一遍
class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> s = new Stack<>();
        int n = 0;
        for (int i : a) {
            while (!s.empty() && s.peek() > 0 && i < 0 && s.peek() < -i) {
                    s.pop();
                    n--;
            }
            if (!s.empty() && s.peek() > 0 && i < 0 && s.peek() == -i) {
                s.pop();
                n--;
                continue;
            }
            if (s.empty() || (!s.empty() && ((s.peek() > 0 && i > 0) || 
                                             (s.peek() < 0 && i < 0) || 
                                             (s.peek() < 0 && i > 0)))){
                s.push(i);
                n++;
                continue;
            }   
            if (s.peek() > 0 && i < 0 && s.peek() > -i)
                continue;  
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}
