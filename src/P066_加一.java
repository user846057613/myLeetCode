public class P066_加一 {
    public int[] plusOne(int[] digits) {
        int in = 1;
        int index = digits.length - 1;
        while (index >= 0 && in > 0) {
            int num = digits[index] + in;
            in = num / 10;
            digits[index] = num % 10;
            index--;
        }
        if(in > 0) {
            int[] next = new int[digits.length + 1];
            next[0] = 1;
            System.arraycopy(digits,0,next,1,digits.length);
            return next;
        }else{
            return digits;
        }
    }
}
