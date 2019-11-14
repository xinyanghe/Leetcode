//Notice max and index, easy to confuse
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int n = A.length, max = n;
        for (int i = 0; i < n; i++){
            int index = find(A, max);
            flip(A, index);
            flip(A, max - 1);
            result.add(index + 1);
            result.add(max--);
        }
        return result;
    }
    
     private int find(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    private void flip(int[] A, int index) {
        int i = 0, j = index;
        while (i < j) {
            int temp = A[i];
            A[i++] = A[j]; //Notice i change after this line
            A[j--] = temp;
        }
    }
}
