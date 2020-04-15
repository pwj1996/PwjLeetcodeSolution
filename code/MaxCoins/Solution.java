class Solution {
    public int maxCoins(int[] nums) {
        return dpmaxCoins(nums);
    }

    //递归，分治
    private int selfMaxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }

        newNums[0] = newNums[n - 1] = 1;
        int[][] mem = new int[n][n];

        return divideAndMem(mem, newNums, 0, n - 1);
    }

    private int divideAndMem(int[][] mem, int[] newNums, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }

        if (mem[left][right] > 0) {
            return mem[left][right];
        }

        int max = 0;
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, newNums[i] * newNums[left] * newNums[right] + 
                divideAndMem(mem, newNums, left, i) + divideAndMem(mem, newNums, i, right));
        }

        mem[left][right] = max;
        return max;
    }

    public int dpmaxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] new_nums = new int[n];

        for(int i = 0; i < nums.length; i++){
            new_nums[i+1] = nums[i];
        }

        new_nums[0] = new_nums[n - 1] = 1;

        int[][] dp = new int[n][n];

        for (int left = n - 2; left > -1; left--) {
            for (int right = left + 2; right < n; right++) {
                for (int i = left + 1; i < right; ++i) {
                    dp[left][right] = Math.max(dp[left][right],
                    new_nums[left] * new_nums[i] * new_nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
            

        return dp[0][n - 1];
    }
}
