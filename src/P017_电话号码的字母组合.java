import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P017_电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            Integer num = Integer.parseInt(digits.charAt(i)+"");
            String s = map.get(num);
            if(result.isEmpty()) {
                for (int j = 0; j < s.length(); j++) {
                    result.add(s.charAt(j)+"");
                }
            }else {
                ArrayList<String> newResult = new ArrayList<>();
                for (int j = 0; j < result.size(); j++) {
                    String old = result.get(j);
                    for (int k = 0; k < s.length(); k++) {
                        String newString = old + s.charAt(k);
                        newResult.add(newString);
                    }
                }
                result.clear();
                result.addAll(newResult);
            }
        }
        return result;
    }
}
