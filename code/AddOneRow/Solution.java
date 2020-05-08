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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        } else {
            selfAddOneRow(root, v, d, 1);
        }
        return root;
    }

    private void selfAddOneRow(TreeNode root, int v, int d, int deep) {
        
        if (root == null) {
            return;
        }

        if (deep == d - 1) {
            TreeNode leftTreeNode = new TreeNode(v);
            TreeNode rightTreeNode = new TreeNode(v);

            leftTreeNode.left = root.left;
            root.left = leftTreeNode;
            rightTreeNode.right = root.right;
            root.right = rightTreeNode; 
        }

        if (deep < d - 1) {
            selfAddOneRow(root.left, v, d, deep + 1);
        }      
        if (deep < d - 1) {
            selfAddOneRow(root.right, v, d, deep + 1);
        }
        
    }

    
}
