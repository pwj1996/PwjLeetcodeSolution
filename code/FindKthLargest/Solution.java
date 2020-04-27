class Solution {
    public int findKthLargest(int[] nums, int k) {
        return selfFindKthLargestHeap(nums, k);
    }

    //先排序，后取值
    private int selfFindKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(nums);

        return nums[nums.length - k];
    }

    //利用队列
    private int selfFindKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }
}
