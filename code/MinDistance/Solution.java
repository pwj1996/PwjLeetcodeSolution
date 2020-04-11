class Solution {
    public int minDistance(String word1, String word2) {
        return selfMinDistance(word1, word2);
    }

    private int selfMinDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        //某一个为空的情况
        if (length1 * length2 == 0) {
            return length1 + length2;
        }

        int[][] dp = new int[length1 + 1][length2 + 1];

        //dp初始化, word1或word2其中一个为空
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                int left = dp[i][j - 1] + 1;
                int up = dp[i - 1][j] + 1;
                int lu = 0;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    lu = dp[i - 1][j - 1];
                } else {
                    lu = dp[i - 1][j - 1] + 1;
                }

                dp[i][j] = Math.min(Math.min(left, up), lu);
            }
        }

        return dp[length1][length2];
    }
}
