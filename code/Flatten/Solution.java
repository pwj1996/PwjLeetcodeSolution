/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        return selfIterflatten(head);
    }

    Node resHead = null, resTail = null;
    private Node selfIterflatten(Node head) {
        if (head == null) {
            return head;
        }
        //head可能就有Child节点
        Node iter = head, temp = null;     
        Stack<Node> stack = new Stack<>();

        while(iter != null || !stack.isEmpty()) {
            if (iter == null) {
                iter = stack.pop();
            }
            
            if (iter.child != null) {
                //System.out.println("child");
                //注：先递进入栈
                if (iter.next != null) {
                    stack.push(iter.next);
                }
                //注：再对节点重组操作
                addTail(iter);
                
                //指向child
                temp = iter;
                iter = iter.child;
                temp.child = null;
                continue;
            } else {
                //注意：先对iter递进，在对temp操作，防止其对后面的操作产生影响
                temp = iter;
                iter = iter.next;
                addTail(temp);
            }
        }

        return resHead;
    }
    
    private void addTail(Node node) {
        //System.out.println(node.val);
        if (resTail == null) {
            resHead = node;
            resTail = node;
        } else {
            node.prev = resTail;
            resTail.next = node;
            resTail = node;
        }
        resTail.next = null;
    }
}
