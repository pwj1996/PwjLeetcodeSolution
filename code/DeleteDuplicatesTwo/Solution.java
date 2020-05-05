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

    private selfDeleteDuplicates(ListNode head) {
        
    }
    private ListNode selfFromIDeleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        int curVal = head.val;
        ListNode curNode = head, iter = head.next, preNode = head;
        Set<Integer> valSet = new HashSet<>();
 
        while(iter != null) {
            if (iter.val != curVal) {
                curNode = iter;
                curVal = iter.val;
            } else {
                valSet.add(curVal);
                curNode.next = iter.next;
            }
            iter = iter.next;
        }

        iter = head;
        preNode = head;
        //想清楚可能的情况
        while(iter != null) {
            if (valSet.contains(iter.val)) {
                //删除节点，可能为头节点
                if (iter == head) {
                    head = head.next;
                    preNode = head;
                } else {
                    //删除中间节点
                    preNode.next = iter.next;
                }
            } else {
                //不删除节点
                preNode = iter;
            }

            iter = iter.next;
        }

        return head;
    }
}
