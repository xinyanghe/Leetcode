class Solution {
    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            if (Y % 2 == 1)
                Y += 1;
            else
                Y /= 2;
            res ++;
        }
        return (res + X - Y);
    }
}
