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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        //selfRecursionPostorderTraversal(root, res);
        selfIterPostorderTraversal(root, res);
        return res;
    }

    
    //递归
    private void selfRecursionPostorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        selfRecursionPostorderTraversal(root.left, res);
        selfRecursionPostorderTraversal(root.right, res);
        res.add(root.val);
    }

    //迭代
    private void selfIterPostorderTraversal(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        TreeNode node = root;

        /*
        后序遍历对每一个节点的访问顺序是：左——》右——》中，其逆顺序就是中-》右-》左。
        则根据其逆顺序入栈（有点类似于前序遍历），在从栈输出
        */
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }

        while (output.size() > 0) {
            TreeNode n = output.pop();
            res.add(n.val);
        }
    }
}
