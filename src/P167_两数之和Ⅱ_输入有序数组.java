public class P167_两数之和Ⅱ_输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right) {
            if(numbers[left] + numbers[right] < target) {
                left++;
            }else if(numbers[left] + numbers[right] > target) {
                right--;
            }else{
                return new int[]{left+1, right+1};
            }
        }
        return new int[]{};
    }
}
