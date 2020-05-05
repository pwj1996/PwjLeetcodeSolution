/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode smallHead = null, smallTail = null;
        ListNode bigHead = null, bigTail = null;
        
        ListNode iter = head, temp = null;
        while(iter != null) {
            //注意：切割出iter，使用temp指向它
            temp = iter;
            iter = iter.next;
            temp.next = null;

            if (temp.val < x) {
                if (smallHead == null) {
                    smallHead = temp;
                    smallTail = temp;
                } else {
                    smallTail.next = temp;
                    smallTail = temp;
                }
            } else {
                if (bigHead == null) {
                    bigHead = temp;
                    bigTail = temp;
                } else {
                    bigTail.next = temp;
                    bigTail = temp;
                }
            }

        }
        //拼接两个部分
        if (smallTail == null) {
            if (bigHead == null) {
                return head;
            } else {
                return bigHead;
            }
        } else {
            smallTail.next = bigHead;
        }
        
        return smallHead;       
    }
}
