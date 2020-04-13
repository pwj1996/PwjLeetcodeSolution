class Solution {
    public int maximalRectangle(char[][] matrix) {
        return selfMaximalRectangle(matrix);
    }

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
}
