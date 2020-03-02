//DFS
class Solution {
    private void restore(List<String> res, String s, int k, String path) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4)
                res.add(path.substring(1));
            return;
        }
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255)
                restore(res, s.substring(i), k + 1, path + "." + part);
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restore(res, s, 0, "");
        return res;
    }
}


//Chen Duxiu
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        String ans = "";
        
        for (int a = 1; a <= 3; a ++) 
            for (int b = 1; b <= 3; b++) 
                for (int c = 1; c <= 3; c++)
                    for (int d = 1; d <= 3; d++)
                        if (a + b + c + d == s.length()) {
                            int A = Integer.valueOf(s.substring(0, a));
                            int B = Integer.valueOf(s.substring(a, a + b));
                            int C = Integer.valueOf(s.substring(a + b, a + b + c));
                            int D = Integer.valueOf(s.substring(a + b + c));
                            if (A <= 255 && B <= 255 && C <= 255 && D <= 255){
                                ans = Integer.toString(A) + "." + Integer.toString(B) + "." + Integer.toString(C) + "." + Integer.toString(D);
                            if (ans.length() == s.length() + 3)
                                res.add(ans);
                            }
                        }
        return res;
    }
}
