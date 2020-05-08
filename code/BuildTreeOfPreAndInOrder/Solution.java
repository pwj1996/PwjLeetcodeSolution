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

    //全局变量
    private int[] preorder;
    private int[] inorder;
    private int preIndex = 0;
    private HashMap<Integer, Integer> inorderIndex = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        //全局变量初始化
        this.preorder = preorder;
        this.inorder = inorder;
        //中序遍历，构造哈希映射
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return selfBuildTree(0, inorder.length);
    }

    private TreeNode selfBuildTree(int left, int right) {

        if (left == right) {
            return null;
        }
        
        //创建root节点
        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderIndex.get(rootVal);
        preIndex++;

        
        root.left = selfBuildTree(left, index);
        root.right = selfBuildTree(index + 1, right);

        return root;
        
    }
}
