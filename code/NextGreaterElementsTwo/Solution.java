class Solution {
    public int[] nextGreaterElements(int[] nums) {
        return selfNextGreaterElements(nums);
    }

    //no stack
    private int[] selfNextGreaterElements(int[] nums) {
        
        int temp = 0, start = 0, j = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                start = 0;
            } else {
                start = i + 1;
            }
            for (j = start; j < nums.length && j != i; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
                //保证循环
                if (j == nums.length - 1) {
                    j = -1;
                }
            }
            if (j == i) {
                res[i] = -1;
            }
        }
        return res;
    }

    //stack 
    private int[] selfNextGreaterElementsStack(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}
