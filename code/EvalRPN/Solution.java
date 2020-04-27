class Solution {
    public int evalRPN(String[] tokens) {
        return selfEvalRPN(tokens);
    }

    private int selfEvalRPN(String[] tokens) {
        //一次入栈，遇到运算符号，pop两次进行运算
        if (tokens.length <= 1) {
            return stringToInt(tokens[0]);
        }

        int num1 = 0, num2 = 0, res = 0;
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (int i = 0; i < tokens.length; i++) {
            if (set.contains(tokens[i])) {
                num2 = stack.pop();
                num1 = stack.pop();
                //num1 ops num2
                res = compute(num1, num2, tokens[i]);
                //System.out.println(num1 + " " + num2 + " " + res);
                stack.push(res);
                //System.out.println(res);
                    
            } else {
                stack.push(stringToInt(tokens[i]));
            }
        }
        return res;
    }

    private int compute(int num1, int num2, String ops) {
        switch(ops) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
        }
        return -1;
    }

    private int stringToInt(String str) {
        char[] chars = str.toCharArray();
        int res = 0, start = 0;
        if (chars[0] == '-') {
            start = 1;
        } else {
            start = 0;
        }
        for (int i = start; i < chars.length; i++) {
            res = (res * 10 + (chars[i] - '0'));
        }

        if (start == 1) {
            res = -res;
        }
        //System.out.println(res + " p");
        return res;
    }
}
