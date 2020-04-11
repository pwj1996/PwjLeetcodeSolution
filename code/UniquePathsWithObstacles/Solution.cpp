class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        //m是列数，n是行数
        int m = obstacleGrid[0].size();
        int n = obstacleGrid.size();

        //cout << m << " " << n << " " << obstacleGrid[n - 1][m - 1] <<endl;

        long int dynamic_array[n][m] = {0};
        memset(dynamic_array,0,sizeof(dynamic_array));

        int i = 0;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dynamic_array[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dynamic_array[i][0] = 1;
        }

        //cout << dynamic_array[0][0] << " " << dynamic_array[0][1] << endl;
        int row = 0, col = 0;
        for (row = 1; row < n; row++) {
            for (col = 1; col < m; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dynamic_array[row][col] = 0;
                    continue;
                }
                dynamic_array[row][col] = dynamic_array[row - 1][col] + dynamic_array[row][col - 1];
            }
        }
        
        return dynamic_array[n - 1][m - 1];
        
    }

   
};
