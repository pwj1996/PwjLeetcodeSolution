class Solution {
    public boolean find132pattern(int[] nums) {
        return selFind132pattern(nums);
    }
    
    //
    private boolean selFind132pattern(int[] nums) {
        if (nums.length <= 0) {
            return false;
        }
        //寻找i之前比nums[i]小的的最小值
        int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= mins[i - 1]){
                mins[i] = mins[i - 1];
            } else {
                mins[i] = nums[i];
            }
        }

        Stack<Integer> stack = new Stack<>();
        //思考例子：20，1，2，3
        //思考例子：0，3，1，2，4
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > mins[j]) {
                //报纸栈的有序（降序）
                while (!stack.isEmpty() && stack.peek() <= mins[j])
                    stack.pop();

                //因为此时的栈顶的是最小的，
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
