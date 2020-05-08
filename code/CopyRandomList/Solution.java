/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    //不能用Set集合，应为Set的元素获取需要遍历
    HashMap<Node, Node> visiteHash = new HashMap<>();
    public Node copyRandomList(Node head) {
        return selfIterCopyRandomList(head);
    }


    //方法一：回溯
    //对每一个节点做复制
    private Node selfRecallCopyRandomList(Node head) {
        if (head == null) {
            return null;
        }


        //应对有环的情况
        if (this.visiteHash.containsKey(head)) {
            return this.visiteHash.get(head);
        }

        Node node = new Node(head.val, null, null);

        this.visiteHash.put(head, node);

        //非递归的表现就是：1）先沿着next对整个链表进行拷贝，并在map中添加映射。2）再从链表开始对random建立拷贝
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
    
    private Node selfIterCopyRandomList(Node head) {
        System.out.println("iter");
        if (head == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Node node = head;
        Node preNode;
        Node newNode;

        //沿next拷贝
        while(node != null) {

            //拷贝节点
            newNode = new Node(node.val, null, null);
            this.visiteHash.put(node, newNode);

            if(queue.isEmpty()) {
                queue.add(newNode);
                node = node.next;
                continue;
            }

            //建立连接
            preNode = queue.remove();
            preNode.next = newNode;
            queue.add(newNode);
            node = node.next;
        }

        //沿random拷贝
        node = head;
        Node newRandom;
        while(node != null) {
            newNode = visiteHash.get(node);
            newRandom = visiteHash.get(node.random);
            newNode.random = newRandom;
            node = node.next;
        }

        return visiteHash.get(head);
    }
}
