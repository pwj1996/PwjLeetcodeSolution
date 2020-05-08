class Solution {
    public int hIndex(int[] citations) {

        //先排序，判断数组元素的后面的长度（length - index）和数组元素（citatiosn[index]）的大小，当前者小于后者时，返回结果
        Arrays.sort(citations);

        int i = 0 ;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }

        return i;
    }
}
