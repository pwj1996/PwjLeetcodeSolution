/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        return selfRemoveZeroSumSublists(head);
    }

    private ListNode selfRemoveZeroSumSublists(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode iter = newHead;

        Map<Integer, ListNode> sumMap = new HashMap<>();
        int sum = 0;
        while(iter != null) {
            System.out.println(iter.val);
            sum += iter.val;
            sumMap.put(sum, iter);
            iter = iter.next;
        }

        //System.out.println("end init");
        iter = newHead;
        sum = 0;
        while(iter != null) {
            System.out.println(iter.val);
            sum += iter.val;
            iter.next = sumMap.get(sum).next;
            iter = iter.next;
        }

        return newHead.next;
    }
}
