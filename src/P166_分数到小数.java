import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P166_分数到小数 {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNagtive = false;
        long divide = denominator;
        long num = numerator;
        if(num < 0) {
            num = Math.abs(num);
            isNagtive = !isNagtive;
        }
        if(denominator < 0) {
            divide = Math.abs(divide);
            isNagtive = !isNagtive;
        }
        List<String> s = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        HashMap<Long,Integer> map = new HashMap<>();
        if(num == 0){
            return "0";
        }
        while (num < divide) {
            s.add("0");
            map.put(num,s.size() - 1);
            num*=10;
        }
        s.add(num / divide + "");
        map.put(num, s.size() - 1);
        num %= divide;
        int index = -1;
        while (num != 0) {
            num *= 10;
            if(map.containsKey(num)) {
                index = map.get(num);
                break;
            }
            s.add(num/divide+"");
            map.put(num, s.size() - 1);
            if(num >= divide) {
                num %= divide;
            }
        }
        String head = s.get(0);
        if(isNagtive) {
            sb.append("-");
        }
        sb.append(head);
        if(index == -1 && s.size() == 1) {
            return sb.toString();
        }
        sb.append(".");
        if(index == -1) {
            for (int i = 1; i < s.size(); i++) {
                sb.append(s.get(i));
            }
        }else{
            for (int i = 1; i < index; i++) {
                sb.append(s.get(i));
            }
            sb.append("(");
            for (int i = index; i < s.size(); i++) {
                sb.append(s.get(i));
            }
            sb.append(")");
        }
        return sb.toString();
    }

    @Test
    public void test() {
        fractionToDecimal(-1,-2147483648);
    }
}
