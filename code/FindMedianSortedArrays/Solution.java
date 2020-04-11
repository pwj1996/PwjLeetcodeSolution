class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return selfFindMedianSortedArrays(nums1, nums2);
    }
    
    private double selfFindMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] tempN = nums1;
            nums1 = nums2;
            nums2 = tempN;

            int temp = n;
            n = m;
            m = temp;
        }
        //保证此时 m <= n, nums1是较短的数组

        //注意halflen中是m+n+1, 当m+n为偶数的时候，+1没有作用；当m+n为奇数的时候，左边比右边多一个数字
        int iMin = 0, iMax = m, i = 0, j = 0, halflen = (m + n + 1) / 2;
        while(iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = halflen - i;

            if (i < iMax && nums2[j - 1] > nums1[i]) {
                //i增大
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j] ) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) { 
                    maxLeft = nums2[j-1]; 
                } else if (j == 0) { 
                    maxLeft = nums1[i-1];
                } else { 
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]); 
                }
                //因为左边的比右边的多一个数字，所以为奇数的时候直接返回左边的最大值
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
