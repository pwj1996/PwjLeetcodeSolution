/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        return selfReverseBetween(head, m, n);
    }

    private ListNode selfReverseBetween(ListNode head, int m, int n) {

        //基本思路：寻找到指定的m到n的链表，并记录到断开链表的首尾指针
        //

        ListNode oldTail = null;
        ListNode reverseHead = null, reverseTail = null;
        
        //不需要反转的情况：m==n 或 head为空的情况
        if (head == null || n == m) {
            return head;
        }

        //找到第m个节点，循环结束后，从iter指向的节点开始反转
        ListNode iter = head;
        int count = 1;
        while(count < m) {
            oldTail = iter;
            iter = iter.next;
            count++;
        }
        reverseTail = iter;

        ListNode resverseTempNode = null;
        //
        while(m <= n) {
            resverseTempNode = iter;
            iter = iter.next;
            resverseTempNode.next = reverseHead;
            reverseHead = resverseTempNode;
            m++;
        }

        //反转后拼接
        if (oldTail == null) {
            head = reverseHead;
        } else {
            oldTail.next = reverseHead;
        }
        
        reverseTail.next = iter;

        return head;
    }
}
