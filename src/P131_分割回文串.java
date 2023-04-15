import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class P131_分割回文串 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0,i+1);
            if(isString(sub)) {
                if( i + 1 < s.length()) {
                    List<List<String>> next = partition(s.substring(i+1));
                    if(!next.isEmpty()) {
                        for (int j = 0; j < next.size(); j++) {
                            List<String> now = next.get(j);
                            List<String> newNow = new ArrayList<>();
                            newNow.add(sub);
                            newNow.addAll(now);
                            next.set(j,newNow);
                        }
                        ans.addAll(next);
                    }else{
                        continue;
                    }
                }else{
                    ans.add(new ArrayList<String>(){{add(sub);}});
                }
            }
        }
        return ans;
    }

    private boolean isString(String sub) {
        boolean flag = true;
        int n = sub.length();
        for (int i = 0; i < n/2; i++) {
            if(sub.charAt(i) != sub.charAt(n-1-i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
