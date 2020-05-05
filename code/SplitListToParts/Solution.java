/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        return selfSplitListToParts(root, k);
    }

    private ListNode[] selfSplitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int[] resNum = new int[k];
        if (root == null) {
            return res;
        }

        int count = 1;
        ListNode iter = root, preIter = null;
        while(iter != null) {
            iter = iter.next;
            count++;
        }

        int splitNum = count / k;
        int reminder = count % k;
        for(int i = 0; i < resNum.length; i++) {
            if (reminder != 0) {
                resNum[i] = splitNum + 1;
                reminder--;
            } else {
                resNum[i] = splitNum;
            }
        }

        int index = 1;
        res[0] = root;
        iter = root;
        preIter = null;
        count = 0;
        while(iter != null && index < resNum.length) {
            if (count == resNum[index]) {
                preIter.next = null;
                res[index] = iter;
                index++;
                count = 0;
                continue;
            }
            preIter = iter;
            iter = iter.next;
            count++;
        }

        return res;
    }
    //拆分后不连续
    private ListNode[] selfNOSplitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        ListNode[] resTail = new ListNode[k];

        int count = 0;
        ListNode iter = root, temp = null;
        while(iter != null) {
            temp = iter;
            iter = iter.next;
            temp.next = null;

            if (res[count % k] == null) {
                res[count % k] = temp;
                resTail[count % k] = temp;
            } else {
                resTail[count % k].next = temp;
                resTail[count % k] = temp;
            }
            count++;
        }

        return res;
    }
}
