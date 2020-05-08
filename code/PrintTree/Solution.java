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
    public List<List<String>> printTree(TreeNode root) {
        //通过最大深度获得矩阵的row数，把树看作一个完全二叉树，计算col数
        int row = maxDepth(root);
        int col = (1 << row) - 1;
        //初始化res，所有元素设为 “” ，再通过深度遍历将对应的位置进行赋值
        List<List<String>> res = new ArrayList<>(row);
        for (int i = 0; i < row; i++) {
            List<String> temp = new ArrayList<>(col);
            System.out.println(temp.size());
            for (int j = 0; j < col; j++) {
                temp.add("");
            }
            res.add(temp);
        }

        int k = 1 << (row - 1);
        int r = 0;
        int c = col >> 1;
        dfs(root, k, r, c, res);
        return res;
    }

    private void dfs(TreeNode root, int k, int row, int col, List<List<String>> res) {
        if (root == null) {
            return;
        } 
        List<String> temp = res.get(row);
        temp.set(col, String.valueOf(root.val));
        k >>= 1;
        dfs(root.left, k, row + 1, col - k, res);
        dfs(root.right, k, row + 1, col + k, res);
    }

    //获得最大深度
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
}
