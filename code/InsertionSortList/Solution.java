/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        return selfInsertionSortList(head);
    }

    private ListNode selfInsertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode iter = head, newHead = null, insertIter = null, preInsertIter = null, temp = null;
        //待排元素
        while(iter != null) {
            //先断开节点
            temp = iter;
            iter = iter.next;
            temp.next = null;

            //第一个元素
            if (newHead == null) {
                newHead = temp;
                continue;
            }

            //后面的元素
            insertIter = newHead;
            preInsertIter = null;
            while(insertIter != null) {
                if (insertIter.val > temp.val) {
                    break;
                }
                preInsertIter = insertIter;
                insertIter = insertIter.next;
            }    

            //此时可能有三种情况：1）pre为空，insert=head;2)pre, insert都不为空；3)pre不为空，insert为空
            if (preInsertIter == null) {
                newHead = temp;
            } else {
                preInsertIter.next = temp;
            }
            temp.next = insertIter;
        }

        return newHead;
    }
}
