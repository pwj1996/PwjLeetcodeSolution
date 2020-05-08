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
    public int findBottomLeftValue(TreeNode root) {
        return selfDFSFindBottomLeftValue(root);
    }

    //DFS
    private int selfDFSFindBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        
        queue1.add(root);
        TreeNode first = null;
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            first = queue1.peek();
            while(!queue1.isEmpty()) {
                TreeNode node = queue1.remove();
                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }   
            }

            if (queue1.isEmpty() && queue2.isEmpty()) {
                return first.val;
            }

            first = queue2.peek();
            while(!queue2.isEmpty()) {
                TreeNode node = queue2.remove();

                if (node.left != null) {
                    queue1.add(node.left);
                }
                if (node.right != null) {
                    queue1.add(node.right);
                }   
            }

            if (queue1.isEmpty() && queue2.isEmpty()) {
                return first.val;
            }
        }

        return first.val;
    }
}
