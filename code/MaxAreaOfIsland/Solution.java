class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        return selfMaxAreaOfIsland(grid);
    }

    private int selfMaxAreaOfIsland(int[][] grid) {
        int[][] newGrid = new int[grid.length][];

        int maxArea = 0, upNum = 0, leftNum = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                
                maxArea = Math.max(maxArea, dfs(grid, row, col));
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        //边界
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        
        //防止访问多次，则在每次访问一个节点的时候，先置为0，防止向回遍历
        grid[row][col] = 0;
        int up = dfs(grid, row - 1, col);
        int down = dfs(grid, row + 1, col);
        int left = dfs(grid, row, col - 1);
        int right = dfs(grid, row, col + 1);
        //放这里会内存溢出，因为会不停的来回跳
        //grid[row][col] = 0;
        return up + down + left + right + 1;
    }

/* 错误
    private int selfMaxAreaOfIsland(int[][] grid) {
        int[][] newGrid = new int[grid.length][];

        int maxArea = 0, upNum = 0, leftNum = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    upNum = 0;
                    leftNum = 0;
                    if (row - 1 > 0) {
                        upNum = grid[row - 1][col];
                        grid[row - 1][col] = 0
                    } 
                    if (col - 1 > 0) {
                        leftNum = grid[row][col - 1];
                    }
                    grid[row][col] += upNum + leftNum;
                } else {
                    grid[row][col] = 0;
                }
                maxArea = maxArea > grid[row][col] ? maxArea : grid[row][col];
            }
        }

        return maxArea;
    }*/
}
