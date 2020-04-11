class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        return selfSpiralOrder(matrix);
    }

    private List<Integer> res;
    private List<Integer> selfSpiralOrder(int[][] martrix) {

        res = new LinkedList<>();
        if (martrix.length == 0 || martrix[0].length == 0) {
            return res;
        }
        int start = 0, m = martrix.length - 1, n = martrix[0].length - 1;

        
        while(start < m && start < n) {
            subSpiralOrder(martrix, start++, m--, n--);
        }

        System.out.println(m + " " + n);
        if (start == m) {
            //一横列
            while(start <= n) {
                res.add(martrix[m][start++]);
            }
        } else if (start == n) {
            while(start <= m) {
                res.add(martrix[start++][n]);
            }
        }

        return res;
    }

    private void subSpiralOrder(int[][] martrix, int start, int m, int n) {
        //m行 n列
        //先向右访问
        int right = start;
        while(right <= n - 1) {
            res.add(martrix[start][right]);
            right++;
        }

        int down = start;
        while(down <= m - 1) {
            res.add(martrix[down][n]);
            down++;
        }

        int left = n;
        while(left >= start + 1) {
            res.add(martrix[m][left]);
            left--;
        }

        int up = m;
        while(up >= start + 1) {
            res.add(martrix[up][start]);
            up--;
        }

    }
}
