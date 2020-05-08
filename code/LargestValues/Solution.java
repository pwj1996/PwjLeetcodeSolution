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
    public List<Integer> largestValues(TreeNode root) {
        return selfLargestValues(root);
    }

    //双队列
    private List<Integer> selfLargestValues(TreeNode root) {
        
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root);
        TreeNode temp = null;
        int max = 0;
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                max = (queue1.peek()).val;
            } else {
                continue;
            }
            while(!queue1.isEmpty()) {
                temp = queue1.remove();
                max = temp.val > max ? temp.val : max;
                if (temp.left != null) {
                    queue2.add(temp.left);
                } 
                if (temp.right != null) {
                    queue2.add(temp.right);
                }
            }
            res.add(max);
            System.out.println(max);

            if (!queue2.isEmpty()) {
                max = (queue2.peek()).val;
            } else {
                continue;
            }
            while(!queue2.isEmpty()) {
                temp = queue2.remove();
                max = temp.val > max ? temp.val : max;
                if (temp.left != null) {
                    queue1.add(temp.left);
                } 
                if (temp.right != null) {
                    queue1.add(temp.right);
                }
            }
            res.add(max);
        }

        return res;
    }

    //单队列
    private List<Integer> selfSingleQueuelargestValues(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null)
            return rst;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            rst.add(max);
        }
        return rst;
    }
}
