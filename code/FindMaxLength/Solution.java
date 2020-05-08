class Solution {
    public int findMaxLength(int[] nums) {
        return selfFindMaxLength(nums);
    }

    private int selfFindMaxLength(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            if (map.containsKey(count)) {
                res = (i - map.get(count)) > res ? (i - map.get(count)) : res;
            } else {
                map.put(count, i);
            }
        }

        return res;
    }
}
