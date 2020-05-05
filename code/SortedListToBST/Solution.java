/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return selfSortedListToBST(head);
    }

    private TreeNode selfSortedListToBST(ListNode head) {
        Map<Integer, ListNode> nodeIndex = new HashMap<>();

        ListNode iter = head;
        int index = 0;
        while(iter != null) {
            nodeIndex.put(index, iter);
            index++;
            iter = iter.next;
        }

        int maxIndex = --index;
        return buildTree(nodeIndex, head, 0, maxIndex);
    }

    private TreeNode buildTree(Map nodeIndex, ListNode head, int start, int end) {
        System.out.println(start + " " + end);
        if (start > end) {
            return null;
        } else if (start == end) {
            ListNode temp = (ListNode)nodeIndex.get(start);
            TreeNode root = new TreeNode(temp.val);
            return root;
        }

        int mid = (start + end) / 2;
        ListNode temp = (ListNode)nodeIndex.get(mid);
        TreeNode root = new TreeNode(temp.val);

       
        root.right = buildTree(nodeIndex, head, mid + 1, end);
        root.left = buildTree(nodeIndex, head, start, mid - 1);
        return root;
    }
}
