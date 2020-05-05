/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        return selfRotateRight(head, k);
    }

    private ListNode selfRotateRight(ListNode head, int k) {
        
        ListNode temp = head, tail = null, newhead = null;

        if (head == null || k == 0) {
            return head;
        }

        int nodeNum = 0;
        while(temp != null) {
            nodeNum++;
            tail = temp;
            temp = temp.next;
        }
    
        //找到倒数第k个节点，作为头节点，即正数第nodeNum - k 个节点作为尾节点
        k = k % nodeNum;
        k = nodeNum - k;

        //不用移动的情况
        if (k == 0 || k == nodeNum) {
            return head;
        }

        //找到第nodeNum = k个节点，
        temp = head;
        int count = 1;
        while(count < k && temp != null) {
            temp = temp.next;
            count++;
        }

        //拼接
        newhead = temp.next;
        temp.next = null;
        tail.next = head;

        return newhead; 
        
    }
}
