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
    int count = 0;
    public int countNodes(TreeNode root) {
        //最简单的方式直接遍历

        selfCountNode(root);
        return count;
    }

    private void selfCountNode(TreeNode root) {
        if (root == null) {
            return;
        }
        count++;

        selfCountNode(root.left);
        selfCountNode(root.right);
    }
}
