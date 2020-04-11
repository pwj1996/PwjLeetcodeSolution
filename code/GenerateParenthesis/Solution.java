class Solution {
    // public List<String> generateParenthesis(int n) {
    //     //按嵌套的层数划分
    //     //等于n的只有一个，等于零的只有一个
    //     List<String> res = new LinkedList<String>();
    //     StringBuilder builder = new StringBuilder();
        
    //     if(n == 0){
    //         return res;
    //     }

    //     List<String>[] dp = new List[n + 1];
    //     dp[0] = new LinkedList();
    //     dp[0].add("");

    //     dp[1] = new LinkedList();
    //     dp[1].add("()");

    //     for(int i = 2; i <= n; i++) {
    //         List<String> listOfI = new LinkedList<>();
    //         for (int j = 0; j < i; j++) {
    //             List<String> nowList1 = dp[j];
    //             List<String> nowList2 = dp[i-1-j];
    //             for (String k1: nowList1) {
    //                 for (String k2: nowList2) {
    //                     if (k1.equals("")) {
    //                         k1 = "";
    //                     }
    //                     if (k2.equals("")) {
    //                         k2 = "";
    //                     }
    //                     builder.append("(" + k1 + ")" + k2);
    //                     listOfI.add(builder.toString());
    //                     builder.delete(0, builder.length());
    //                 }
    //             }
    //         }
    //         dp[i] = listOfI;
    //     }
    //     return dp[n];
    // }

    private int depth = 0;
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        System.out.println(cur + " " + depth);
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max) {
            depth++;
            backtrack(ans, cur+"(", open+1, close, max);
            depth--;
        }
            
        if (close < open) {
            depth++;
            backtrack(ans, cur+")", open, close+1, max);
            depth--;
        }
            
    }
}
