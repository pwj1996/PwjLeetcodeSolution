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
    
    public int kthSmallest(TreeNode root, int k) {
        return selfKthSmallest(root, k);
    }

    //递归版
    private void selfKthSmallestRecursion(TreeNode root, int k) {
        
    }
    //非递归版
    private int selfKthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while(node != null) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            do {
                node = stack.pop();
                count++;
                if (count == k) {
                    break;
                }
                node = node.right;
            } while(node == null && !stack.isEmpty());

            if (count == k) {
                break;
            }
        }

        return node.val;
    }
}
