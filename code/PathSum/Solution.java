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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        
        selfPathSum(root, sum, res, temp);
        
        return res;

    }

    
    private void selfPathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
        
        
        if (root == null) {
            return;
        }

        temp.add(root.val);
        sum = sum - root.val;

        //到达叶子节点
        if (root.left == null && root.right == null) {
            //判断是否满足条件
            if (sum == 0) {
                res.add(new ArrayList<>(temp));
            }
        }

        //递归分解
        selfPathSum(root.left, sum, res, temp);
        selfPathSum(root.right, sum, res, temp);

        //从temp删除该节点
        temp.remove(temp.size() - 1);
    }
}
