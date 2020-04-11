class Solution {

    List<List<Integer>> res = new ArrayList();
    int n, k;

    //类似于字符串的所有排列
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k) {
            res.add(new ArrayList(curr));
        }
        
        for (int i = first; i < n; ++i) {
            //不同于字符串的所有排列, 用过的不能在用,所以不用交换
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return res;
    }
}
