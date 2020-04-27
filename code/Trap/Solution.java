class Solution {
    public int trap(int[] height) {
        return selfStackTrap(height);
    }

    //暴力
    private int selfTrap(int[] height) {
        int res = 0;
        int leftMax = 0, rightMax = 0;

        for (int i = 1; i < height.length - 1; i++) {
            leftMax = 0;
            rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            res += Math.min(rightMax, leftMax) - height[i];
        }

        return res;
    }

    //存储，空间换时间
    private int selfStorageTrap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int res = 0;
        int tempMax = height[0];
        for (int i = 1; i < height.length - 1; i++) {
            tempMax = Math.max(tempMax, height[i]);
            leftMax[i] = tempMax;
        }

        tempMax = height[height.length - 1];
        for (int i = height.length - 2; i >= 1; i--) {
            tempMax = Math.max(tempMax, height[i]);
            rightMax[i] = tempMax;
        }

        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        return res;
    }

    //利用stack，类似括号的形式
    private int selfStackTrap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int high = Math.min(height[stack.peek()], height[i]) - height[top];
                int distance = i - stack.peek() - 1;
                System.out.println(high + " " + distance);
                res += high * distance;
            }
            stack.push(i);
        }

        return res;
    }
}
