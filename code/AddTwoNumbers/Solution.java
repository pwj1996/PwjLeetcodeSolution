/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return selfAddTwoNumbers(l1, l2);
    }

    private ListNode selfAddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resHead = null, temp = null;
        int res = 0;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        
        ListNode iter = l1;
        while(iter != null) {
            stack1.push(iter);
            iter = iter.next;
        }
        iter = l2;
        while(iter != null) {
            stack2.push(iter);
            iter = iter.next;
        }

        int reminder = 0;
        int num1 = 0, num2 = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                num1 = 0;
            } else {
                num1 = stack1.pop().val;
            }

            if (stack2.isEmpty()) {
                num2 = 0;
            } else {
                num2 = stack2.pop().val;
            }

            res = (num1 + num2 + reminder) % 10;
            reminder = (num1 + num2 + reminder) / 10;
            

            temp = new ListNode(res);
            temp.next = resHead;
            resHead = temp;
        }

        if (reminder != 0) {
            temp = new ListNode(reminder);
            temp.next = resHead;
            resHead = temp;
        }

        return resHead;
    }
}
