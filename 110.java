/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    private int NOT_BALANCED = -1; 
    
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != NOT_BALANCED;
    }
    
    private int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if(left == NOT_BALANCED || right == NOT_BALANCED)
            return NOT_BALANCED;
        
        if(Math.abs(left - right) > 1)
            return NOT_BALANCED;
        
        return Math.max(left, right) + 1;
        
    }
}


