class Solution {
    public int uniquePaths(int m, int n) {
        return selfOptionUniquePaths(m, n);
    }

    //动态规划
    private int selfUniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int col = 1; col <= n; col++) {
            dp[1][col] = 1;
        }

        for (int row = 1; row <= m; row++) {
            dp[row][1] = 1;
        }

        for (int row = 2; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        return dp[m][n];
    }

    //动态规划
    //空间复杂度优化
    private int selfOptionUniquePaths(int m, int n) {
        int[] dp = new int[n + 1];

        for (int col = 1; col <= n; col++) {
            dp[col] = 1;
        }

        for (int row = 2; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                dp[col] = dp[col] + dp[col - 1];
            }
        }

        return dp[n];
    }
}
