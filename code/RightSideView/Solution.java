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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        //找层序遍历每一层的最后一个元素
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        TreeNode node;

        if (root == null) {
            return res;
        }
        queue1.add(root);
        int flag = 1;
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
        
            while(!queue1.isEmpty()) {
                node = queue1.remove();
                
                if (flag == 1) {
                    res.add(node.val);
                    flag = 0;
                }
                
                if (node.right != null) {
                    queue2.add(node.right);
                }
                if (node.left != null) {
                    queue2.add(node.left); 
                }
            }
            flag = 1;

            while(!queue2.isEmpty()) {
                
                node = queue2.remove();

                if (flag == 1) {
                    res.add(node.val);
                    flag = 0;
                }

                if (node.right != null) {
                    queue1.add(node.right);
                }
                if (node.left != null) {
                    queue1.add(node.left); 
                }
            }
            flag = 1;
        }

        return res;
    }
}
