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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return selfConstructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode selfConstructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        //寻找最大元素索引：maxIndex
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            maxIndex = nums[i] > nums[maxIndex] ? i : maxIndex;
        } 

        //创建树
        TreeNode treeNode = new TreeNode(nums[maxIndex]);
        treeNode.left = selfConstructMaximumBinaryTree(nums, start, maxIndex - 1);
        treeNode.right = selfConstructMaximumBinaryTree(nums, maxIndex + 1, end);

        return treeNode;
    }
}
