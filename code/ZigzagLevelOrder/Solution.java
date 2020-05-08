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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new LinkedList<>();

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        if (root == null) {
            return res;    
        }

        TreeNode node;
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            
            //层序从左往右，stack2（右往左）先压入左节点
            List<Integer> temp = new LinkedList<Integer>();
            while(!stack1.isEmpty()) {
                node = stack1.pop();
                temp.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }
            if (temp.size() != 0) {
                res.add(temp);
            }
            

            //层序从右往左，stack1（左往右）先压入右节点，因为右节点后出（栈先进后出）
            temp = new LinkedList<Integer>();
            while(!stack2.isEmpty()) {
                node = stack2.pop();
                temp.add(node.val);
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
            if (temp.size() != 0)
                res.add(temp);
        }

        return res;
    }

    //层序遍历
    private void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        TreeNode node;
        queue.add(root);
        do {
            node = queue.remove();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        } while(!queue.isEmpty());
    }
}
