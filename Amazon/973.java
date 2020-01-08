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
import java.util.concurrent.ThreadLocalRandom;

class Solution {
    int[][]points;
    private int dis(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }
    
    private void sort(int i, int j, int K) {
        if (i >= j) return;
        int k = ThreadLocalRandom.current().nextInt(i,j);
        swap(i, k);
        
        int mid = partition(i, j);
        int remain = mid - i + 1;
        if (remain > K)
            sort(i, mid - 1, K);
        else if (remain < K)
            sort(mid + 1, j, K - remain);    
    }
    
    private int partition(int i, int j) {
        int oi = i;
        int pivot = dis(i);
        i++;
        
        while (true) {//注意这里不要死循环
            while (dis(i) <= pivot && i < j)
                i++;
            while (dis(j) >= pivot && i <= j)
                j--;
            if (i >= j)
                break;
            swap(i, j);
        }
        swap(oi, j);
        return j;
    }
    
    private void swap(int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
    
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        sort(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }
}
