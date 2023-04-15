public class P088_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int num = 0;
        while (num < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                num++;
            }else {
                insertAndMove(nums2[j], nums1, i);
                j++;
            }
            i++;
        }
        if(j == n) {
            return;
        }else{
            for (int k = j; k < n; k++) {
                nums1[i++] = nums2[k];
            }
            return;
        }
    }

    private void insertAndMove(int num, int[] nums1, int index) {
        for (int i = nums1.length - 2; i >= index ; i--) {
            nums1[i + 1] = nums1[i];
        }
        nums1[index] = num;
    }
}
