class Solution {
    public int[] dailyTemperatures(int[] T) {
        return selfNostackDailyTemperatures(T);
    }

    private int[] selfDailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for (int i = T.length - 1; i >= 0; --i) {
            //stack单调升序
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                System.out.println(T[stack.peek()]);
                res[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return res;
    }

    //不使用stack
    private int[] selfNostackDailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = 0;

        //从倒数第二个开始
        for (int i = T.length - 2; i >= 0; i--) {
            int j = 0;
            for (j = i; j < T.length; j++) {
                res[i] = 1;
                // 分别和 j + res[j] 天后的温度比较
                //通过res记录栈中的内容
                if (res[j] == 0 || T[i] < T[j + res[j]]) {
                    //j没有执行
                    break;
                }
            }

            if (res[j] == 0) {
                res[i] = 0;
            } else {
                res[i] = j + res[j] - i;
            }
        }

        return res;
    }
}
