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

    public TreeNode deleteNode(TreeNode root, int key) {
        return selfDeleteNode(root, key);
    }

     //递归2
    private TreeNode selfDeleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.val) {
            root.left = selfDeleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = selfDeleteNode(root.right, key);
            return root;
        }

        //root.val == key
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left != null) {
            int left = maxOfLeft(root.left);
            root.val = left;
            root.left = selfDeleteNode(root.left, left);
        } else {
            int right = minOfRight(root.right);
            root.val = right;
            root.right = selfDeleteNode(root.right, right);
        }

        return root;        
    }
    /* 
        1、找到目标节点
        2、先寻找左子树最大节点，如果没有寻找右子树最小节点；如果存在节点，则将该节点设为新的目标节点，没有的话停止操作
        这样写在判断的时候有问题
    */
    private TreeNode recueDeleteNode(TreeNode root, int key) {
        
        if (root == null) {
            return null;
        }
        
        TreeNode target = root, preTarget = null;
        while(target.val != key) {
            if (key > target.val) {
                target = target.right;
            } else {
                target = target.left;
            }
        }

        System.out.println(target.val);
        if (target.left == null && target.right == null) {
            target = null;
        } else if (target.left != null) {
            int maxLeftValue = maxOfLeft(target.left);
            target.val = maxLeftValue;
            //System.out.println(maxLeftValue);
            target.left = recueDeleteNode(target.left, maxLeftValue);
        } else {
            int minRightValue = minOfRight(target.right);
            target.val = minRightValue;
            //System.out.println(minRightValue);
            target.right = recueDeleteNode(target.right, minRightValue);
        }
        
        if (target == root) {
            return target;
        } 
        return root;
    }

    private int maxOfLeft(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
    private int minOfRight(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        } 
        return root.val;
    }
}
