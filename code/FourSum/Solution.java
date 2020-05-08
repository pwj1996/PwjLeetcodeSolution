class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        //
        if (nums == null || nums.length < 4) {
            return new ArrayList<>(result);
        }
        //数组排序
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length;j ++) {
                int k = j + 1;
                int x = nums.length - 1;
                
                while(k < x) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[x];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[x]);
                        result.add(list);
                        //为什么同时：因为此时num已经排过序
                        k++;
                        x--;
                    } else if (sum > target) {
                        x--;
                    } else {
                        k++;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
