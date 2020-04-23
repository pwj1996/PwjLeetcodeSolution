class Solution {
    public int removeDuplicates(int[] nums) {
        return selfRemoveDuplicates(nums);
    }

    private int selfRemoveDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;
        //注意初始化状态
        int count = 1;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] == nums[fast] && count == 1) {
                count++;
                nums[++slow] = nums[fast];
            } else if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
                count = 1;
            }
        }

        return slow + 1;
    }
}
