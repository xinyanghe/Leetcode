class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder res = new StringBuilder(); //Java 6 特性，可以往字符串中间和后面加东西 .append .insert
        res.append(((numerator > 0) ^ (denominator > 0)) ?  "-" : "");
        long num = Math.abs((long)numerator); //注意数据类型转换
        long den = Math.abs((long)denominator);
        
        res.append(num / den);
        num %= den;
        
        if (num == 0)
            return res.toString();
        
        res.append(".");
        
        Map<Long, Integer> frac = new HashMap<>();
        frac.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (frac.containsKey(num)) {
                res.insert(frac.get(num), "(");
                res.append(")");
                return res.toString();
            }
            frac.put(num, res.length());
        }
        return res.toString();
    }
}
