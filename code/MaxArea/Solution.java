class Solution {
    public int maxArea(int[] height) {
        return doublePointMaxArea(height);
    }

    //双指针
    //减少了重复计算，当移动一个指针的时候，就是判定该指针已经不能作为一个边界条件了
    private int doublePointMaxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
