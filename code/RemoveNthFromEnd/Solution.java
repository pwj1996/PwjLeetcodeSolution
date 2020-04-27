/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return selfRemoveNthFromEnd(head, n);
    }
    /*private ListNode zhengshuSelfRemoveNthFromEnd(ListNode head, int n) {
    
        ListNode pre = null, cur = head;
        int count = 1;

        while(count != n) {
            pre = cur;
            cur = cur.next;
            count++;
        }

        pre.next = cur.next;

    }*/

    private ListNode selfRemoveNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head, pre = null;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        int count = 0;
        while(count != n + 1 && pre != head) {
            pre = stack.pop();
            cur = pre.next;
            count++;
        }

        if (count != n + 1) {
            pre = head.next;
        } else {
            pre.next = cur.next;
        }
    
        while(!stack.isEmpty()) {
            pre = stack.pop();
        }

        return pre;
    }
}
