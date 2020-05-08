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
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : selfIsSymmetric(root.left, root.right);
    }

    //判断两个对称的节点是否相等
    private boolean selfIsSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null || leftRoot.val != rightRoot.val) {
            return false;
        }

        return selfIsSymmetric(leftRoot.left, rightRoot.right) && selfIsSymmetric(leftRoot.right, rightRoot.left);
    }

    // private boolean stackIsSymmetric(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }

    //     Queue left = new LinkedList<>();
    //     Queue right = new LinkedList<>();
        
    // }
}
