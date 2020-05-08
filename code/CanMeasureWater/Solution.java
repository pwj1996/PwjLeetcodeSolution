class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == 0 || y == 0) return z == 0 || x + y == z;
        return z % GCD(x, y) == 0;
    }

    public int GCD(int a,int b) {
        if(b==0)
            return a;
        else
            return GCD(b,a%b);
    }

    
}
