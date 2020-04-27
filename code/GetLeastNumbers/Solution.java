class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        return selfGetLeastNumbers(arr, k);
    }

    private int[] selfGetLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        int[] res = new int[k];
        int index = 0;
        for (int num: arr) {
            heap.add(num);
            if (heap.size() > arr.length - k) {
                res[index++] = heap.poll();
            }
        }   

        return res;
    }
}
