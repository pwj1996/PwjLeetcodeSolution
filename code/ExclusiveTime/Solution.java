class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        return selfExclusiveTime(n, logs);
    }

    private int[] selfExclusiveTime(int n, List<String> logs) {
        int[] res= new int[n];
        Stack<Integer> stack = new Stack<>();

        //初始化
        String[] strings = logs.get(0).split(":");
        stack.push(Integer.parseInt(strings[0]));
        int prev = Integer.parseInt(strings[2]);

        //开始遍历
        for (int i = 1; i < logs.size(); i++) {
            strings = logs.get(i).split(":");
            if (strings[1].equals("start")) {
                //前一个任务停止运行
                System.out.println(strings[0]);
                if (!stack.isEmpty()) {
                    res[stack.peek()] += Integer.parseInt(strings[2]) - prev;

                }
                stack.push(Integer.parseInt(strings[0]));
                prev = Integer.parseInt(strings[2]);
            } else {
                //当前任务停止运行
                res[stack.peek()] += Integer.parseInt(strings[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(strings[2]) + 1;
            }
        }

        return res;
    }
}
