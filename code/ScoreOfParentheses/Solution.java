class Solution {
    public int scoreOfParentheses(String S) {
        return selfScoreOfParentheses(S, 0, S.length());
    }

    //分治
    private int selfScoreOfParentheses(String s, int start, int end) {
        int k = 0;
        int flag = 0, res = 0;

        for (k = start; k < end; k++) {
            if (s.charAt(k) == '(') {
                flag++;
            } else {
                flag--;
            }

            if (flag == 0) {
                if (k - start == 1) {
                    //()
                    res++;
                } else {
                    //（A）
                    res += 2 * selfScoreOfParentheses(s, start + 1, k);
                }
                start = k + 1;
            }
        }

        return res;
    }

    //栈
    private int selfStackScoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
