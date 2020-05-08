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
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        selfFlatten(root, queue);

        if (queue.isEmpty()) {
            return;
        }
        
        TreeNode node = queue.remove();
        while(!queue.isEmpty()) {
            node.right = queue.remove();
            node.left = null;
            node = node.right;
        }
        
    }

    private void selfFlatten(TreeNode root, Queue queue) {
        if (root == null) {
            return;
        }

        queue.add(root);
        selfFlatten(root.left, queue);
        selfFlatten(root.right, queue);

    }
}
