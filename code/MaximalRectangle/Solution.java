class Solution {
    public int maximalRectangle(char[][] matrix) {
        return dpMaximalRectangle(matrix);
    }

    //时间复杂度：N*N*M
    private int selfMaximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] mem = new int[matrix.length][matrix[0].length];

        int maxArea = 0, tempArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    mem[i][j] = (j - 1 < 0 ? 1 : mem[i][j - 1] + 1);
                }
                System.out.println(mem[i][j]);

                int width = mem[i][j];
                for (int row = i; row >= 0; row--) {
                    width = Math.min(width, mem[row][j]);
                    tempArea = width * (i - row + 1);
                    if (tempArea > maxArea) {
                        maxArea = tempArea;
                    }
                }
            }
        }

        return maxArea;
    }

    //时间复杂度：N*M
    private int dpMaximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int curLeft = 0, curRight = n, maxArea = 0;

        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(right, n);

        for (int i = 0; i < m; i++) {
            curLeft = 0;
            curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n; 
                    curRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }

        return maxArea;
    }
}
