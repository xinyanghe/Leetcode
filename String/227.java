//热评第一的做法也很几把傻逼
class Solution {
    public int calculate(String ss) {
        String s = ss.replace(" ", "");//去空格
        Stack<Integer> res = new Stack<>();
        int num = 0;
        char op = '+';//一开始num是0所以相当于 0 + 后面的
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //积累数字
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            //如果为运算符说明数字结束，此时op为之前记载的运算符（非当前），将之前的运算符与当前的数字进行操作，并记载新的运算符
            if (!Character.isDigit(c) || i == s.length() - 1) {//最后的数字需要进栈
                if (op == '+')
                    res.push(num);
                if (op == '-')
                    res.push(-num);
                if (op == '*')
                    res.push(res.pop() * num);
                if (op == '/')
                    res.push(res.pop() / num);
                //更新运算符
                op = c;
                //数字置0
                num = 0;
            }
        }
        //栈居然也可以这样用？
        for (int r : res) {
            num += r;
        }
        return num;
    }
}
