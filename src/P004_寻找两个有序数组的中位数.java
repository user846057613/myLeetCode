import org.junit.Test;

public class P004_寻找两个有序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int len = length1 + length2;
        if(len % 2 == 0) {
            return (findKNum(nums1, 0, length1 -1, nums2, 0, length2 - 1, len/2) +
                    findKNum(nums1, 0, length1-1, nums2, 0, length2-1, len/2+1)) * 0.5;
        }else {
            return findKNum(nums1, 0, length1-1, nums2, 0, length2-1, (len+1)/2);
        }
    }

    public int findKNum(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        if(length1 > length2) {
            return findKNum(nums2, start2, end2, nums1, start1, end1, k);
        }
        if(length1 == 0) {
            return nums2[start2 + k - 1];
        }
        if(k == 1) {
            return nums1[start1] < nums2[start2] ? nums1[start1] : nums2[start2];
        }
        int index1 = start1 + Math.min(length1, k / 2) - 1;
        int index2 = start2 + Math.min(length1, k / 2) - 1;

        if(nums1[index1] < nums2[index2]) {
            return findKNum(nums1, index1 + 1, end1, nums2, start2, end2, k - (index1 - start1 + 1));
        }else {
            return findKNum(nums1, start1, end1, nums2, index2 + 1, end2, k - (index2 - start2 + 1));
        }
    }

    @Test
    public void test() {
        int[] num1 = {1,3};
        int[] num2 = {2};
        findMedianSortedArrays(num1,num2);
    }
}
