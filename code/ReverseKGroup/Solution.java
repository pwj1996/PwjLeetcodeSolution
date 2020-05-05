/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return selfReverseKGroup(head, k);
    }

    private ListNode selfReverseKGroup(ListNode head, int k) {
        ListNode newHead = null, newTail = null;
        ListNode reverseHead = head;
        ListNode oldHead = head, temp = null;
        int count = 0;
        
        while(oldHead != null) {
            reverseHead = oldHead;
            //截取相应长度的链表
            count = 1;
            while(count < k && oldHead != null) {
                oldHead = oldHead.next;
                count++;
            }
            if (oldHead == null) {
                //剩下的链表中不够长度:1)直接不够长度，2）剩下的不够长度
                if(newHead == null) {
                    newHead = reverseHead;
                } else {
                    newTail.next = reverseHead;
                    //System.out.println(reverseHead.val);
                }       
                return newHead;
            } 

            temp = oldHead;
            //System.out.println(oldHead.val);
            oldHead = oldHead.next;
            temp.next = null;

            //拼接成新的节点
            if (newHead == null) {
                newHead = reverseList(reverseHead);
                newTail = newHead;
            } else {
                //System.out.println(reverseHead.val);
                newTail.next = reverseList(reverseHead);
            }

            //赋值newTail 
            while(newTail.next != null) {
                newTail = newTail.next;
            }
        }
        
        return newHead;
    }

    //反转链表，返回头节点
    private ListNode reverseList(ListNode head) {
        ListNode newHead = null, temp = null;
        
        while(head != null) {
            temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }

        return newHead;
    }
}
