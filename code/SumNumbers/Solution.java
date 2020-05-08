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
    public int sumNumbers(TreeNode root) {
        /*
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<>();
        int sum = 0;
        selfSumNumberPath(root, res, temp);
        
        for (List<Integer> iter : res) {
            sum += toInteger(iter);
        }
        */

        selfSumNumberPathImpro(root, 0);        

        return res;
    }

    private int res;

    //直接获得结果
    private void selfSumNumberPathImpro(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += val;
            //不要在这里return
            //return;
        }
        
        selfSumNumberPathImpro(root.left, val);
        selfSumNumberPathImpro(root.right, val);
        val -= root.val;
    }

    //获得所有数字字符串
    private void selfSumNumberPath(TreeNode root, List<List<Integer>> res, List<Integer> temp) {
        if (root == null) {
            return;
        }

        temp.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList(temp));
            //不要在这里return
            //return;
        }
        
        selfSumNumberPath(root.left, res, temp);
        selfSumNumberPath(root.right, res, temp);
        temp.remove(temp.size() - 1);
    }

    private int toInteger(List<Integer> list) {
        int res = 0;

        while(!list.isEmpty()) {
            res = res * 10 + list.remove(0);
        }

        return res;
    }


}
