/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return selfMergeKLists(lists);
    }
    
    private ListNode selfMergeKLists(ListNode[] lists) {
        
        if (lists.length == 0) {
            return null;
        }
        
        int count = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        
        ListNode newHead = null, newTail = null;
        int minValue = 0, minIndex = Integer.MAX_VALUE;
        
        while(count > 0) {
            minValue = Integer.MAX_VALUE;
            //寻找最小的节点
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && minValue > lists[i].val) {
                    minValue = lists[i].val;
                    minIndex = i;
                }
            }
            
            //新链表中添加节点
            if (newHead == null) {
                newHead = lists[minIndex];
            } else {
                newTail.next = lists[minIndex];
            }
            newTail = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            newTail.next = null;
            
            if (lists[minIndex] == null) {
                count--;
            }
        }
        
        return newHead;
        
    }
}
