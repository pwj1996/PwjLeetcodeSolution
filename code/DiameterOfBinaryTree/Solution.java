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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        return selfdiameterOfBinaryTree(root);
    }

    private int selfdiameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    //计算以该节点为根节的最大路径
    //计算最大深度
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
    
        ans = Math.max(ans, (leftDepth + rightDepth) + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
