public class P014_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.length == 0) {
            return sb.toString();
        }
        sb.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
                int index = sb.length() - 1;
                if(index >= strs[i].length()) {
                    sb.delete(strs[i].length(), sb.length());
                    index = strs[i].length()-1;
                }
                while (index >= 0) {
                    if (sb.charAt(index) != strs[i].charAt(index)) {
                        sb.delete(index, sb.length());
                    }
                    index--;
                }
                if(sb.length() == 0) {
                    break;
                }
        }
        return sb.toString();
    }
}
