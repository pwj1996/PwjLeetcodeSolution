/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        return selfNextLargerNodes(head);
    }

    private int[] selfNextLargerNodes(ListNode head) {
        Stack<ListNode> nodeStack = new Stack<>();
        int size = 0;
        ListNode iter = head;

        while(iter != null) {
            nodeStack.push(iter);
            iter = iter.next;
            size++;
        }
        
        //初始化，通过添加prev来记录前一个节点的值
        int j = 0, prev = nodeStack.pop().val;
        int[] res = new int[size];
        res[size - 1] = 0;

        ListNode node = null;
        for (int i = res.length -2; i >= 0; i--) {
            node = nodeStack.pop();
            
            //使用 prev 和 j = i 来解决与相邻的前一个元素的判断
            for (j = i; j < res.length; j++) {
                if (node.val < prev) {
                    res[i] = prev;
                    break;
                }
                prev = res[j + 1];
                if (prev == 0) {
                    break;
                }
            }

            if (prev == 0 || j >= res.length) {
                res[i] = 0;
            }

            prev = node.val;
        }

        return res;
    }
}
