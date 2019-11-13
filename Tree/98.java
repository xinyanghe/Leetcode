//2019.11.12 勉强看懂 自己写肯定是写不对的

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
    private TreeNode lastNode;
    private boolean isValid;
    
    public boolean isValidBST(TreeNode root) {
        lastNode = null;
        isValid = true;
        inorderTraverse(root);
        return isValid;
    }
    
    private void inorderTraverse(TreeNode root){
        if(root == null)
            return;
        
        inorderTraverse(root.left);
        if(lastNode != null && lastNode.val >= root.val){
            isValid = false;
            return;
        }
        lastNode = root;
        inorderTraverse(root.right);
    }  
}


//Divide Conquer
class ResultType{
    boolean isBST;
    public TreeNode maxNode, minNode;
    public ResultType(boolean isBST){
        this.isBST = isBST;
        this.maxNode = null;
        this.minNode = null;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return divideConquer(root).isBST;
    }
    
    private ResultType divideConquer(TreeNode root){
        if(root == null)
            return new ResultType(true);
        ResultType notBST = new ResultType(false);
        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);
        if(!left.isBST || !right.isBST){
            return notBST;
        }
        if(left.maxNode != null && left.maxNode.val >= root.val)
            return notBST;
        if(right.minNode != null && right.minNode.val <= root.val)
            return notBST;
        
        ResultType result = new ResultType(true);
        result.minNode = left.minNode != null ? left.minNode : root;
        result.maxNode = right.maxNode != null ? right.maxNode : root;
        return result;
        
    }
}
