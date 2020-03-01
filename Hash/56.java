class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0 || intervals[0].length == 0 || intervals == null) return new int[0][0];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int key = intervals[0][0], value = intervals[0][1], count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (value < intervals[i + 1][0]){
                map.put(key, value);
                count ++;
                key = intervals[i + 1][0];
                value = intervals[i + 1][1];
            }
            else {
                if (intervals[i + 1][1] > value)
                    value = intervals[i + 1][1];
                else
                    continue;
            }   
        }
        map.put(key, value);
        count ++;
        
        int[][] res = new int[count][2];
        int r = 0, c = 0;
        for (int k : map.keySet()) {
            res[r][0] = k;
            r ++;
        }
        for (int v : map.values()) {
            res[c][1] = v;
            c++;
        }
        return res;
    }
}
