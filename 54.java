class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null)
            return null;
        if(matrix.length == 0 || matrix[0].length == 0)
            return res;
        int l = 0, r = matrix[0].length - 1;
        int t = 0, d = matrix.length - 1;
        int rem = matrix.length * matrix[0].length;
        while (rem != 0) {
            for (int i = l; i <= r && rem != 0; i++){
                res.add(matrix[t][i]);
                rem --;
            }
            for (int i = t + 1; i <= d - 1 && rem != 0; i++){
                res.add(matrix[i][r]);
                rem --;
            }
            for (int i = r; i >= l && rem != 0; i--){
                res.add(matrix[d][i]);
                rem --;
            }
            for (int i = d - 1; i >= t + 1 && rem != 0; i--){
                res.add(matrix[i][l]);
                rem --;
            }
            l++; r--;
            t++; d--;
        }
        return res;
    }
}
