class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] cA = new int[7];
        int[] cB = new int[7];
        int[] same = new int[7];
        for (int i = 0; i < A.length; i++) {
            cA[A[i]] ++;
            cB[B[i]] ++;
            if (A[i] == B[i])
                same[A[i]] ++;
        }
        for (int i = 1; i <= 6; i ++) {
            if (cA[i] + cB[i] - same[i] == A.length) {
                return (Math.min(cA[i], cB[i]) - same[i]);
            }
        }
        return -1;
    }
}
