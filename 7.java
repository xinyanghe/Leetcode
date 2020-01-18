class Solution {
    public int reverse(int x) {
        int digit = 0; 
        int y = x;
        while (x != 0) {
            x = x / 10;
            digit++;
        }
        long z = 0;
        for (int i = digit; i > 0; i --) {
            z += (y % 10) * Math.pow (10, i - 1);
            y = y / 10;
            if (z > Integer.MAX_VALUE || z < Integer.MIN_VALUE)
                return 0;
        }
        
        return (int)z;
    }
}
