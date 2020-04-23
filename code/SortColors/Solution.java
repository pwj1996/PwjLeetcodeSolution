class Solution {
    public void sortColors(int[] nums) {
        OnSortColors(nums);
    }

    private void selfSortColors(int[] nums) {
        int zeroEnd = -1, twoStart = nums.length;
        int change = 0;

        for (int i = 0; i < twoStart; i++) {
            //System.out.println(nums[i]);
            if (nums[i] == 0) {
                zeroEnd++;
                change = nums[i];
                nums[i] = nums[zeroEnd];
                nums[zeroEnd] = change;
                
            } else if (nums[i] == 2) {
                twoStart--;
                change = nums[i];
                nums[i] = nums[twoStart];
                nums[twoStart] = change;
                i--;
                System.out.println("end" + nums[nums.length - 1]);
            }
        }
    }

    private void OnSortColors(int[] nums) {
        int[] count = new int[3];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count[index] != 0) {
                nums[i] = index;
                count[index]--;
            } else {
                index++;
                i--;
            }
        }
    }
    
}
