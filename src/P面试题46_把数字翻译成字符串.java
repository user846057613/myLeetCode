import org.junit.Test;

public class P面试题46_把数字翻译成字符串 {
    public int translateNum(int num) {
        String s = num + "";
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        char n1 = s.charAt(0);
        char n2 = s.charAt(1);
        if(n1 == '0' || n1 >= '3') return translateNum(Integer.parseInt(s.substring(1)));
        else if(n1 == '2' && n2 >= '6') {
            if(s.length() > 2) {
                return translateNum(Integer.parseInt(s.substring(2)));
            }else{
                return 1;
            }
        }else{
            if(s.length() > 2) return translateNum(Integer.parseInt(s.substring(1))) +
                    translateNum(Integer.parseInt(s.substring(2)));
            else{
                return 2;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(translateNum(25));
    }
}
