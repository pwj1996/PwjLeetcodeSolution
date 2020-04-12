class Solution {
    public int multiply(int A, int B) {
        int temp = 0;
        if (A > B) {
            temp = A;
            A = B;
            B = temp;
        }
        return selfMultiply(A, B);
    }

    public int selfMultiply(int A, int B) {
        if (A == 0) {
            return 0;
        }

        return B + selfMultiply(A - 1, B);
    }
}
