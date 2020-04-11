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
    public int rob(TreeNode root) {
        return selfRob(root);
    }

    //完全递归
    private int selfRob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int ll = 0, lr = 0, rl = 0, rr = 0;
        //选择root
        if (root.left != null) {
            ll = selfRob(root.left.left);
            lr = selfRob(root.left.right);
        } 
        if (root.right != null) {
            rl = selfRob(root.right.left);
            rr = selfRob(root.right.right);
        } 
        
        int chooseRoot = root.val + ll + lr + rl + rr;
            
        //不选择root
        int unChooseRoot = selfRob(root.left) + selfRob(root.right);
        return chooseRoot > unChooseRoot ? chooseRoot : unChooseRoot;
    }

    //如果使用动态规划，可以将树的结构抽象为二维数组，row标记节点的位置，col标记该节点是否被选择的两种不同的结果
    private int[] help(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = help(root.left);
        int[] right = help(root.right);
        return new int[]{left[1] + right[1] + root.val, Math.max(left[0],left[1]) + Math.max(right[0],right[1])};
    }
}
