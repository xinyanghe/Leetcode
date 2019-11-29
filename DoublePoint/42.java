class Solution {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        
        int[] maxHeight = new int[height.length];
        maxHeight[0] = 0;
        for (int i = 0; i < height.length - 1; i++) {
            maxHeight[i + 1] = Math.max(maxHeight[i], height[i]);
        }
        
        int max = 0; 
        int area = 0;
        for (int i = height.length - 1; i > 0 ; i--) {
            area += Math.min(max,maxHeight[i]) > height[i] 
                    ? Math.min(max, maxHeight[i]) - height[i]
                    : 0;
            max = Math.max(max, height[i]);
 
        }
        
        return area;
    }
}





class Solution {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        
        int ans = 0;
        int l = 0, r = height.length - 1;
        int l_max = 0, r_max = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if(height[l] >= l_max) {
                    l_max = height[l];
                }else{
                    ans += l_max - height[l];
                } 
                l++;
            }
            else {
                if(height[r] >= r_max) {
                    r_max = height[r];
                }else{
                    ans += r_max - height[r];
                } 
                r--;
            }
        }
        return ans;
    }
}
