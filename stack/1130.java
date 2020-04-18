class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int a : arr) {
            while (!stack.empty() && stack.peek() < a) {
                if (stack.size() == 1) {
                    res += stack.pop() * a;//Notice边界条件
                }
                else 
                    res += stack.pop() * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() >= 2) {//notice边界条件
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
