class Solution {
    public int removeDuplicates(int[] nums) {
        return selfRemoveDuplicates(nums);
    }

    private int selfRemoveDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
