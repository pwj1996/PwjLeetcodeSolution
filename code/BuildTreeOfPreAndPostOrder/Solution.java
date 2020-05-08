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
    private int[] postorder;
    private int[] inorder;
    private int postIndex;
    private HashMap<Integer, Integer> inorderIndex = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        //全局变量初始化
        this.postorder = postorder;
        this.inorder = inorder;
        this.postIndex = postorder.length - 1;
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
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderIndex.get(rootVal);
        postIndex--;

        //因为是后序，紧挨根节点的是右子树的节点，由于postIndex--，所以先构造右子树
        root.right = selfBuildTree(index + 1, right);
        root.left = selfBuildTree(left, index);
        
        return root;
        
    }
}
