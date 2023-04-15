import org.junit.Test;

public class P394_字符串解码 {

    public int index = 0;

    public String decodeString(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (int i = index; i < ch.length; i++) {
            if(ch[i] >= '0' && ch[i] <= '9') {
                sb.append(ch[i]);
                continue;
            }else if(ch[i] == '[') {
                index = i + 1;
                String s1 = decodeString(s);
                i = index;
                int time = 1;
                if( sb.length() > 0) {
                    time = Integer.parseInt(sb.toString());
                    sb.delete(0,sb.length());
                }
                for (int j = 0; j < time; j++) {
                    ans.append(s1);
                }
            }else if(ch[i] == ']') {
                index = i;
                return ans.toString();
            }else {
                ans.append(ch[i]);
            }
        }
        return ans.toString();
    }

    @Test
    public void test() {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
