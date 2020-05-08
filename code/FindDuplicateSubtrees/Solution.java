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
    private Map<String, Integer> map;
    private List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new LinkedList<>();
        if (root != null) {
            collect(root);
        }

        return res;        
    }

    private String collect(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String serialize = root.val + "," + collect(root.left) + "," + collect(root.right);
        map.put(serialize, map.getOrDefault(serialize, 0) + 1);
        if (map.get(serialize) == 2) {
            res.add(root);
        }
        return serialize;        
    }
}
