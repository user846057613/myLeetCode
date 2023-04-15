public class P038_外观数列 {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }else{
            String pre = countAndSay(n-1);
            int num = 1;
            char c = pre.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < pre.length(); i++) {
                if(c == pre.charAt(i)) {
                    num++;
                }else{
                    sb.append(num);
                    sb.append(c);
                    c = pre.charAt(i);
                    num = 1;
                }
            }
            sb.append(num);
            sb.append(c);
            return sb.toString();
        }
    }
}
