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
    public void recoverTree(TreeNode root) {
        selfRecoverTree(root);
        
        if (secondErrorNode == null) {
            secondErrorNode = secondErrorTempNode;
            //System.out.println("second");
        }

        int temp = firstErrorNode.val;
        firstErrorNode.val = secondErrorNode.val;
        secondErrorNode.val = temp;
    }

    private TreeNode preNode = null, firstErrorNode = null, secondErrorNode = null, secondErrorTempNode;
    
    private void selfRecoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        selfRecoverTree(root.left);
        //
        if (firstErrorNode == null) {
            //没有找到第一个出错节点
            if (preNode == null) {
                preNode = root;
            } else {
                if (root.val > preNode.val) {
                    preNode = root;
                } else {
                    //此时prenode是第一个错误节点
                    firstErrorNode = preNode;
                    preNode = root;
                    secondErrorTempNode = root;
                    //System.out.println("prenode is " + preNode.val);
                } 
            }
        } else if (secondErrorNode == null) {
            //找到第二个出错节点，有两种情况
            //第二种
            if (root.val < preNode.val) {
                secondErrorNode = root;
            }
        }
        selfRecoverTree(root.right);
    }
}
