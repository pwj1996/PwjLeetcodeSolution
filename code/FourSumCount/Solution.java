class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        return selfFourSumCount(A, B, C, D);
    }

    private int selfFourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //利用Hashmap记录A[i] + B[j]的结果，方便检索
        Map<Integer, Integer> abMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                abMap.put(A[i] + B[j], abMap.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (abMap.containsKey(-(C[i] + D[j]))) {
                    res += abMap.get(-(C[i] + D[j]));
                }
            }
        }

        return res;
    }
}
