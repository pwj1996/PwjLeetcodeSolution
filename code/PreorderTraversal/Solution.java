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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        selfPreorderTraversalIterSingle(root, res);
        
        return res;
    }

    //递归版
    private void selfPreorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        selfPreorderTraversal(root.left, list);
        selfPreorderTraversal(root.right, list);
    }

    //非递归版，双循环
    private void selfPreorderTraversalIter(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode node = root;
        //第一重循环，一直走左子树
        do {
            // 出栈的情况，遇到叶子节点
            //找到符合情况的右子节点，以该节点为开始继续走其左子树
            //当栈为空时，结束
            while(node == null && !stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
            if (node == null) {
                break;
            }
            list.add(node.val);
            stack.push(node);
            node = node.left;
        } while(!stack.isEmpty());
    }

    /*
    //循环中的多余判断
    private void selfPreorderTraversalIterSingle(TreeNode root, List<Integer> list) {
        
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode iter = root;

        while(iter != null || !stack.isEmpty()) {
            //从stack提出下一个遍历点
            if (iter == null) {
                iter = stack.pop();
                iter = iter.right;
            }
            //对每个节点所做的
            if (iter == null) {
                //从stack获得的节点可能为空
                //判断多余，和上面的判断整合
                continue;
            } else {
                //此时iter一定不为空
                list.add(iter.val);
                stack.push(iter);
                iter = iter.left;
            }
        }
    }*/

    private void selfPreorderTraversalIterSingle(TreeNode root, List<Integer> list) {
        
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode iter = root;

        while(iter != null || !stack.isEmpty()) {
            //从stack提出下一个遍历点
            if (iter == null) {
                iter = stack.pop();
                iter = iter.right;
            } else {
                //此时iter一定不为空
                list.add(iter.val);
                stack.push(iter);
                iter = iter.left;
            }
        }
    }
}
