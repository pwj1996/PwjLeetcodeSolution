class Solution {
    public String longestPalindrome(String s) {
        return selfLongestPalindrome(s);
    }
    
    private String selfLongestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        
        //dp记录结果，row表示开始的问题，col表示结束的位置
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        int resStart = 0, resEnd = 0;
        int maxLen = 0;
        //初始化一字母和二字母的回文
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1]) {
                dp[i - 1][i] = true;
                maxLen = 2;
                resStart = i - 1;
                resEnd = i;
            }
            dp[i][i] = true;
        }
        
        //递推公式 dp[row][col] = dp[row - 1][col - 1] + 1
        for (int start = chars.length - 2; start >= 0; start--) {
            for (int end = start + 1; end < chars.length; end++) {
                if (dp[start + 1][end - 1] && chars[start] == chars[end]) {
                    dp[start][end] = true;
                    if (end - start + 1 > maxLen) {
                        maxLen = end - start + 1;
                        resStart = start;
                        resEnd = end;
                    }
                }
            }
        }
        
        return s.substring(resStart, resEnd + 1);
    }
}
