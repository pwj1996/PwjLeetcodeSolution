/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return selfSwapPairs(head);
    }

    private ListNode selfSwapPairs(ListNode head) {
        ListNode oneNode = null, twoNode = null;
        ListNode newHead = null, newTail = null;
        ListNode oldHead = head;

        while(oldHead != null) {
            oneNode = oldHead;
            twoNode = oneNode.next;
            if (twoNode == null) {
                if (newHead == null) {
                    newHead = oneNode;
                    break;
                } else {
                    newTail.next = oneNode;
                    newTail = oneNode;
                    break;
                }
                
            }
            oldHead = twoNode.next;

            
            //交换
            twoNode.next = oneNode;
            oneNode.next = null;

            //添加新链表
            if (newHead == null) {
                newHead = twoNode;
                newTail = oneNode;
            } else {
                newTail.next = twoNode;
                newTail = oneNode;
            }
        }

        if (newHead == null) {
            newHead = newTail;
        }

        return newHead;
    }
}
