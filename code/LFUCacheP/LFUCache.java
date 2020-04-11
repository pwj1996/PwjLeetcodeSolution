class LFUCache {

    private HashMap<Integer, Node> map;
    private TreeSet<Node> set;
    private int capacity, time;

    public LFUCache(int capacity) {
        this.map  = new HashMap<>();
        this.set = new TreeSet<>((Node node1, Node node2) -> (node1.count == node2.count ? node1.time - node2.time : node1.count - node2.count));
        this.capacity = capacity;
        this.time = 0;
        System.out.println("struct end");
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        //存在key
        map.remove(key);
        set.remove(node);

        //更新数据重新放入
        node.count++;
        node.time = ++time;
        set.add(node);
        map.put(key, node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node exit = map.get(key);
        if (exit == null) {
            //map中不存在key
            Node node = new Node(key, value);
            node.time = ++time;
            if (map.size() == capacity) {
                Node rm = set.first();
                set.remove(rm);
                map.remove(rm.key);
            }
            map.put(key, node);           
            set.add(node);
            System.out.println(node.value);
        } else {
            //map中存在key
            map.remove(key);
            set.remove(exit);
            exit.count++;
            exit.time = ++time;
            exit.value = value;
            set.add(exit);
            map.put(key, exit);
        }
        System.out.println(map.size() + " " + set.first());
    }
}

class Node {
    int count = 1;
    int time = 0;
    int key, value;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
