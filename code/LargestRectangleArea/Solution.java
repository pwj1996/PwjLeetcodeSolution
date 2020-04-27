class Solution {
    public int largestRectangleArea(int[] heights) {
        return selfStackLargestRectangleArea(heights);
    }

    //暴力：最终结果肯定是某一个柱子为底
    private int selfLargestRectangleArea(int[] heights) {
        int res = 0;
        int leftLength = 0, rightLength = 0;

        for (int i = 0; i < heights.length; i++) {
            leftLength = 0;
            rightLength = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    leftLength++;
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {
                    rightLength++;
                } else {
                    break;
                }
            }

            res = Math.max(res, heights[i] * (rightLength + leftLength + 1));
        }

        return res;
    }

    Map<Integer, Integer> storage = new HashMap<>();
    //分治：和暴力的想法有类似的地方
    private int selfDivideandruleLargestRectangleArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        
        //找到start 和 end 之间最小的
        int minindex = start;
        for (int i = start; i <= end; i++) {
            if (heights[minindex] > heights[i]) {
                minindex = i;
            }
        }
       return Math.max(heights[minindex] * (end - start + 1), 
            Math.max(selfDivideandruleLargestRectangleArea(heights, start, minindex - 1), selfDivideandruleLargestRectangleArea(heights, minindex + 1, end)));
        
    }

    //stack
    private int selfStackLargestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        
        int maxRes = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                maxRes = Math.max(maxRes, heights[i] * (i - stack.peek() + 1));
                stack.pop();
            }
            stack.push(i);
        }

        while (stack.peek() != -1)
            maxRes = Math.max(maxRes, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxRes;
    }
}
