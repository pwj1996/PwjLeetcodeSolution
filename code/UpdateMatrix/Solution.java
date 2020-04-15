class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        return test(matrix, matrix.length + matrix[0].length);
    }

    // private int[][] BFSupdateMatrix(int[][] matrix) {
    //     int minRes = matrix.length + matrix[0].length;

    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].len) {
    //             if (matrix[i][j] == 1) {
    //                 matrix[i][j] = dfs(i, j, )
    //             }
    //         }
    //     }
    // }

    // private int bfs() {
        
    //     boolean[][] flag = new boolean[matrix.length][matrix[0].length];
    // }
    private int[][] dpUpdateMatrix(int[][] matrix) {
        int max = matrix.length + matrix[0].length;
        int[][] dpLeftUp = new int[matrix.length][matrix[0].length];
        int[][] dpRightDown = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dpLeftUp[i][j] = Math.min(i - 1 < 0 ?  max : dpLeftUp[i - 1][j], j - 1 < 0 ? max : dpLeftUp[i][j - 1]) + 1;
                }
            }
        }

        int[][] test = test(matrix, max);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (test[i][j] != dpLeftUp[i][j]) {
                    System.out.println(i + " " + j);
                }
            }
        }        

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    dpRightDown[i][j] = Math.min(i + 1 >= matrix.length ?  max : dpRightDown[i + 1][j], 
                                                j + 1 >= matrix[0].length ? max : dpRightDown[i][j + 1]) + 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dpLeftUp[i][j] = Math.min(dpLeftUp[i][j], dpRightDown[i][j]);
            }
        }
       
        return dpLeftUp;
    }

    private int[][] test(int[][] matrix, int max) {
        
        int[][] dist = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dist[i][j] = max;
                }
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }

        // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = matrix.length - 1; i >= 0 ; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                // if (j + 1 < matrix[0].length) {
                //     dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                // }
                //  if (i + 1 < matrix.length) {
                //     dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                // }
                int temp = Math.min(i + 1 >= matrix.length ?  max : dist[i + 1][j], 
                                                j + 1 >= matrix[0].length ? max : dist[i][j + 1]) + 1;
                dist[i][j] = Math.min(dist[i][j], temp);
            }
        }

        return dist;

    }
}
