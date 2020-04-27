class Solution {
    public String decodeAtIndex(String S, int K) {
        return selfDecodeAtIndex(S, K);
    }

    private String selfDecodeAtIndex(String S, int K) {
        
        long size = 0;
        int N = S.length();

        // 获得解码后的字符的长度：size
        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }

        for (int i = N-1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }

        throw null;
    }
}
