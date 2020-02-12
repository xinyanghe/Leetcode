class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] tp = new int[timePoints.size()];
        int res = 10000;
        int j = 0;
        for (String t : timePoints) {
            tp[j++] = Integer.valueOf(t.substring(0, 2)) * 60 + Integer.valueOf(t.substring(3));      
        }
        
        Arrays.sort(tp);
        
        int[] diff = new int[tp.length];
        for (int i = 0; i < tp.length - 1; i ++) {
            diff[i] = tp[i + 1] - tp[i];
            int min = Math.min(diff[i], (1440 - diff[i]));
            res = Math.min(min, res);
        }
        diff[tp.length - 1] = tp[0] - tp[tp.length - 1] + 1440;
        int min = Math.min(diff[tp.length - 1], (1440 - diff[tp.length - 1]));
        res = Math.min(min, res);
        return res;
    }
}
