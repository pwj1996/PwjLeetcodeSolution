/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        return selfDeleteDuplicates(head);
    }

    private ListNode selfDeleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        int preval = head.val;
        ListNode preIter = head, iter = head.next;
        
        while(iter != null) {
            if (iter.val != preval) {
                preval = iter.val;
                preIter = iter;
            } else {
                preIter.next = iter.next;
            }

            iter = iter.next;
        }

        return head;
    }
}
