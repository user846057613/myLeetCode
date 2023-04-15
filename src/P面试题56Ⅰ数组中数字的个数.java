public class P面试题56Ⅰ数组中数字的个数 {
    public int[] singleNumbers(int[] nums) {
        int m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            m ^= nums[i];
        }
        int pos = 0;
        while ((m & 1 )== 0) {
            pos++;
            m >>= 1;
        }
        int s1 = 0,s2 = 0;
        boolean flag1 = false, flag2 = false;
        for (int i = 0; i < nums.length; i++) {
            if(((nums[i] >> pos) & 1) == 0){
               if(!flag1) {s1 = nums[i]; flag1 = true;}
               else s1 ^= nums[i];
            }else{
                if(!flag2) {s2 = nums[i]; flag2 = true;}
                else s2 ^= nums[i];
            }
        }
        return new int[]{s1,s2};
    }
}
