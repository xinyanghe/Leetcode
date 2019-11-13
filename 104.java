/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 //Traverse
class Solution {
    private int depth;
    
    public int maxDepth(TreeNode root) {
        depth = 0;
        traverse(root,1);
        return depth;
    }
    private void traverse(TreeNode node, int currDepth){
        if (node == null) {
            return;
        }
        depth = Math.max(depth, currDepth);
        traverse(node.left, currDepth + 1);
        traverse(node.right, currDepth + 1);
    }
}

//Divide and Conquer
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
