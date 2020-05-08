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
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();

        selfInorderTraversalIter(root, res);

        return res;
    }

    //递归版
    private void selfInorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        selfInorderTraversal(root.left, res);
        res.add(root.val);
        selfInorderTraversal(root.right, res);

    } 

    //非递归版
    private void selfInorderTraversalNo(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode node = root;

        //每次循环从一个子树的根节点开始
        while(node != null) {
            //左节点入栈
            //其实就是一直走left
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            //stack弹出，可能直接是右节点，或者继续stack pop，直到其右节点不为空
            //left走到头了，从栈中寻找另外一个开始的节点，没有符合条件的就结束
            do {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            } while(node == null && !stack.isEmpty());
        }
    }

    private void selfInorderTraversalIter(TreeNode root, List<Integer> list) {
        
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode iter = root;

        while(iter != null || !stack.isEmpty()) {
            //从stack提出下一个遍历点
            if (iter == null) {
                iter = stack.pop();
                list.add(iter.val);
                iter = iter.right;
            } else {
                //此时iter一定不为空
                stack.push(iter);
                iter = iter.left;
            }
        }
    }
}
