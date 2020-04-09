class Solution {
    public boolean backspaceCompare(String S, String T) {

        return build(S).equals(build(T));//不能用==
    }
    
    private String build(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) != '#') {
                sb.append(str.charAt(i));
            }
            else {
                if (sb.length() > 0) // 不能用 == null
                    sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
