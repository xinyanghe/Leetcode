//Sort NlogN
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        int[] ds = new int[n];
        for (int i = 0; i < n; i++)
            ds[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        Arrays.sort(ds);
        int distance = ds[K - 1];
        int t = 0;
        int[][] ans = new int[K][2];
        for (int i = 0; i < n; i++) {
            if ((points[i][0] * points[i][0] + points[i][1] * points[i][1]) <= distance) {
                ans[t] = points[i];
                t++;
            }
        }
        return ans;
    }
}

//自己写sort N
