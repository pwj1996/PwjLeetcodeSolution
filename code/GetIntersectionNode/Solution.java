/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return selfGetIntersectionNode(headA, headB);
    }

    private ListNode selfGetIntersectionNode(ListNode headA, ListNode headB) {
        if (headB == null || headA == null) {
            return null;
        }
        ListNode iterA = headA, iterB = headB;

        int count = 0;
        while(iterA != iterB && count <= 2) {
            iterA = iterA.next;
            if (iterA == null) {
                iterA = headB;
                count++;
            }

            iterB = iterB.next;
            if (iterB == null) {
                iterB = headA;
                count++;
            }
        }

        if (iterA != iterB) {
            return null;
        }

        return iterA;
    }
}
