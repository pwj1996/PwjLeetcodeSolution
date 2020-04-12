class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        return selfIntersection(start1, end1, start2, end2);
    }

    //判断点是否在两点之间
    //前提x,y 在其直线上
    private boolean isInside(double x1, double y1, double x2, double y2, double x, double y) {
        //两顶点不一定是按顺序的
        return x >= Math.min(x1, x2) && x <= Math.max(x1, x2) && y >= Math.min(y1, y2) &&  y <= Math.max(y1, y2);
    }

    private boolean isResVoid = true;
    private void updatePoint(double res[], double x, double y) {
        if (isResVoid || res[0] != x) {
            System.out.println("isresvoid");
            if (isResVoid || res[0] > x) {
                res[0] = x;
                res[1] = y;
            }
            isResVoid = false;
        } else {
            if (res[1] > y) {
                res[1] = y;
            }
        }
    }
    //完全从数学
    private double[] selfIntersection(int[] start1, int[] end1, int[] start2, int[] end2) {

        double x1 = start1[0], y1 = start1[1];
        double x2 = end1[0], y2 = end1[1];
        double x3 = start2[0], y3 = start2[1];
        double x4 = end2[0], y4 = end2[1];
        
        double[] res = new double[2];
        //存在平行
        //注意这里的平行判断用乘法
        if ((y2 - y1) * (x4 - x3) == (y4 - y3)* (x2 - x1) ) {
            //在一条直线
            if ((y3 - y2) * (x4 - x1) == (y4 - y1)* (x3 - x2)) {
                if (isInside(x1, y1, x2, y2, x3, y3)) {
                    System.out.println("x3, y3");
                    updatePoint(res, x3, y3);
                }
                if (isInside(x1, y1, x2, y2, x4, y4)) {
                    updatePoint(res, x4, y4);
                } 
                if (isInside(x3, y3, x4, y4, x1, y1)) {
                    updatePoint(res, x1, y1);
                }
                if (isInside(x3, y3, x4, y4, x2, y2)) {
                    updatePoint(res, x2, y2);
                }
            }
        } else {
            // 联立方程得到 t1 和 t2 的值
            double t1 = (double)(x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double)(x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            // 判断 t1 和 t2 是否均在 [0, 1] 之间
            if (t1 >= 0.0 && t1 <= 1.0 && t2 >= 0.0 && t2 <= 1.0) {
                res[0] = x1 + t1 * (x2 - x1);
                res[1] = y1 + t1 * (y2 - y1);
                isResVoid = false;
            }
        }
        if (isResVoid) {
            double[] empyt = new double[0];
            return empyt;
        }
        return res;
    }

    //计算a 和 b
    private double[] getAandB(int[] start, int[] end) {
        double[] res = new double[2];
            //a
            res[0] = (end[1] - start[1]) / (end[0] - start[0]);
            //b
            res[1] = (end[0] * start[1] - start[0] * end[1]) / (end[0] - start[0]);
       
        
        return res;
    }
}
