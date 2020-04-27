class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        return selfValidateStackSequences(pushed, popped);
    }

    private boolean selfValidateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushIter = 0;

        for (int i = 0; i < popped.length; i++) {
            //寻找可以pop的元素
            while ((stack.isEmpty() || stack.peek() != popped[i]) && pushIter < pushed.length) {
                stack.push(pushed[pushIter]);
                pushIter++;
            }

            //对于pop中的每个元素都要满足可以pop的条件，不满足则退出
            if (stack.peek() != popped[i]) {
                return false;
            } else {
                stack.pop();
            }
        }

        return true;
    }
}
