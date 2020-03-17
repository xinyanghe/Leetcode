import java.util.*;

class Node {
    int r, c;
    Node (int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Node> pq = new PriorityQueue<Node>((n1,n2) -> matrix[n1.r][n1.c] - matrix[n2.r][n2.c]);
        for (int i = 0; i < matrix.length && i < k; i ++) {
            pq.add(new Node(i, 0));
        }
        int count = 0, res = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            res = matrix[node.r][node.c];
            count ++;
            if (count == k) {
                break;
            }
            node.c ++;
            if (matrix[0].length > node.c) {
                pq.add(node);
            }
        }
        return res;
    }
}
