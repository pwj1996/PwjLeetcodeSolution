/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        return selfMiddleNode(head);
    }

    private ListNode selfMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        // boolean flag = false;

        // while (fast != null) {
            
        //     if (fast.next != null) {
        //         fast = fast.next.next;
        //     } else {
        //         //奇数的时侯为空
        //         flag = true;
        //         break;
        //     }
        //     low = low.next;
        // }


        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
        
    }
}
