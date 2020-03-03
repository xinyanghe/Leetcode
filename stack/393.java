class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> left = new Stack<>();
        List<Integer> del = new ArrayList();

        for (int i = 0; i < s.length(); i++){
              if (s.charAt(i) == '('){
                  left.push(i);
                  del.add(i);
              }
              if (s.charAt(i) == ')') {
                  if (left.isEmpty())
                      del.add(i);
                  else{
                      left.pop();
                      del.remove(del.size() - 1);
                  }
              }
          }
          for (int i = 0; i < s.length(); i ++) {
              if (del.contains(i)){
                      continue;
              }
              else{
                  res.append(s.charAt(i));
              }
          }
      return res.toString();
      }
}
