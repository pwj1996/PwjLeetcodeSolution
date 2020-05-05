/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        return selfOddEvenList(head);
    }

    private ListNode selfOddEvenList(ListNode head) {
        ListNode oddHead = null, oddTail = null;
        ListNode evenHead = null, evenTail = null;

        int count = 1;
        ListNode iter = head;
        while(iter != null) {
            if (count % 2 == 1) {
                if (oddHead == null) {
                    oddHead = iter;  
                    oddTail = iter;         
                } else {
                    oddTail.next = iter;
                    oddTail = oddTail.next;
                } 
                //System.out.println(iter.val);
            } else {
                if (evenHead == null) {
                    evenHead = iter;
                    evenTail = iter;
                } else {
                    evenTail.next = iter;
                    evenTail = evenTail.next;
                }
                //System.out.println(iter.val);
            }

            count++;
            iter = iter.next;
        }

        if (oddTail != null) {
            oddTail.next = evenHead;
        }
        if (evenTail != null) {
            evenTail.next = null;
        }
        
        return oddHead;
    }
}
