class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        return selfKtopKFrequent(nums, k);
    }

    private List<Integer> selfKtopKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //统计次数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //创建优先队列，其利用堆的结构，根据数组元素的次数进行排序，最大元素在栈顶
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n :map.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }        

        //
        List<Integer> topK = new LinkedList<>();
        while(!heap.isEmpty()) {
            topK.add(heap.poll());
        }
        Collections.reverse(topK);
        return topK;
    }
}
