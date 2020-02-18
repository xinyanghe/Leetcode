class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder res = new StringBuilder();
        res.append(((numerator > 0) ^ (denominator > 0)) ?  "-" : "");
        long num = Math.abs((long)numerator);
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
