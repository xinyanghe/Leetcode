/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Recursion

//Use ResultType to return two value
class Solution {
    class ResultType{
        public boolean isBalanced;
        public int depth;
        
        public ResultType(int depth, boolean isBalanced){
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
        
    }
    
    private ResultType NOT_BALANCED = new ResultType(-1, false); 
    
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root).isBalanced;
    }
    
    private ResultType maxDepth(TreeNode root){
        if(root == null)
            return new ResultType(0, true);
        
        ResultType left = maxDepth(root.left);
        ResultType right = maxDepth(root.right);
        
        if(! left.isBalanced || ! right.isBalanced)
            return NOT_BALANCED;
        
        if(Math.abs(left.depth - right.depth) > 1)
            return NOT_BALANCED;
        
        return new ResultType(Math.max(left.depth, right.depth) + 1, true);
        
    }
}



//General
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


