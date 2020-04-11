class Solution {
    public int rob(int[] nums) {
        return myRob(nums);
    }

    private int selfRob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        dp[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);

        for (int i = nums.length - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];

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
