/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        selfReorderList(head);
    }

    private void selfReorderList(ListNode head) {
        //只有一个节点
        if (head == null || head.next == null) {
            return;
        }

        Deque<ListNode> deque = new ArrayDeque<ListNode>();

        ListNode iter = head.next;
        while(iter != null) {
            deque.addLast(iter);
            iter = iter.next;
        }

        int count = 1;
        iter = head;
        while(!deque.isEmpty()) {
            if (count % 2 == 1) {
                iter.next = deque.removeLast();
            } else {
                iter.next = deque.removeFirst();
            }
            iter = iter.next;
            //System.out.println(iter.val);
            count++;
        }
        iter.next = null;        
    }
}
