class Solution {
    public int nthUglyNumber(int n) {
        return selfNthUglyNumber(n);
    }

    //一个新的丑数一定是前面某一个丑数乘以2、3、5的结果
    private int selfNthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1]=1;
        int index2=1; //此下标对应的数乘2刚好大于上一个丑数，此下标之前的数乘2都小于等于上一个丑数
        int index3=1; //类似上方，乘2变成乘3
        int index5=1; //类似上方，乘3变成乘5
        for(int i=2;i<=n;++i)
        {
            dp[i]=Math.min(Math.min(dp[index2]*2,dp[index3]*3),dp[index5]*5);
            while(dp[index2]*2<=dp[i]) ++index2;
            while(dp[index3]*3<=dp[i]) ++index3;
            while(dp[index5]*5<=dp[i]) ++index5;
        }
        return dp[n];
    }
}
