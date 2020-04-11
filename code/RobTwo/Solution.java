class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), 
                        myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    //动态规划优化空间
    private int myRob(int[] nums) {
        int prePre = 0, pre = 0, temp;
        for(int num : nums) {
            temp = pre;
            pre = Math.max(prePre + num, pre);
            prePre = temp;
        }
        return pre;
    }
}
