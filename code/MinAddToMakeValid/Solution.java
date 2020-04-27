class Solution {
    public int minAddToMakeValid(String S) {
        return selfMinAddToMakeValid(S);
    }

    private int selfMinAddToMakeValid(String S) {
        int stack = 0;
        int houkuohao = 0;

        char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (stack != 0) {
                    stack--;
                } else {
                    houkuohao++;
                }
            } else {
                stack++;
            }
        }

        return stack + houkuohao;
    }
}
