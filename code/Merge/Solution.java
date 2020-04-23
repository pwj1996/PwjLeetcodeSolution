class Solution {
    public int[][] merge(int[][] intervals) {
        return selfMerge(intervals);
    }

    private int[][] selfMerge(int[][] intervals) {
        
        if (intervals.length == 0) {
            return new int[0][0];
        }

        //保证intervals[0]的有序                
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int preIndex = 0;
        for (int i = 1; i < intervals.length; i++) {    
            
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
            //可以合并的情况
            if (intervals[i][0] <= intervals[preIndex][1]) {
                intervals[preIndex][1] = Math.max(intervals[i][1], intervals[preIndex][1]);
                System.out.println(intervals[preIndex][0] + " hebing " + intervals[preIndex][1]);
            } else {
                preIndex++;
                intervals[preIndex][0] = intervals[i][0];
                intervals[preIndex][1] = intervals[i][1];
            }
        }

        int[][] res = new int[preIndex + 1][2];

        for (int i = 0; i <= preIndex; i++) {
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }

        return res;
    }
}
