/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    //把左边一溜加进去
    private void pullLeft(TreeNode root) {
        for (; root != null; root = root.left)
            stack.push(root);
    }
    
    //初始化左边一溜
    public BSTIterator(TreeNode root) {
        pullLeft(root);
    }
    
    //返回最小的一个（栈顶），把下一串最小的加进来
    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = stack.pop();
        pullLeft(tmp.right);
        return tmp.val;
        
    }
    
    //空栈说明没更大的了
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
