import org.junit.Test;

import java.util.HashSet;

public class P466_统计重复个数 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(s1.length() == 0 || s2.length() == 0 || n1 == 0 || n2 == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if(!set.contains(s2.charAt(i))) {
                return 0;
            }
        }

        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        //s2正在被匹配字符的索引
        int index = 0;
        //s2被匹配到的个数
        int count = 0;
        //第i个s1后匹配到的s2的个数
        int[] replaceCount = new int[n1];
        //第i个s1后，下一个s1期望匹配到s2的索引
        int[] replaceIndex = new int[n1];
        int len = s1Char.length;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < len; j++) {
                if(s1Char[j] == s2Char[index]) {
                    index++;
                }
                if(index >= s2Char.length) {
                    count++;
                    index = 0;
                }
            }

            replaceCount[i] = count;
            replaceIndex[i] = index;
            //若发现循环节，剪枝
            for (int j = 0; j < i; j++) {
                if(replaceIndex[j] != index) continue;
                //出现循环节之前，匹配的s2的个数
                int preCount = replaceCount[j];
                //所有循环节，匹配的s2的总个数
                // n1 - (j+1) : 剩余s1的个数， (i-j) 一个循环节中需要的s1的个数
                // ( (n1 - (j+1)) / (i - j) ) ： 循环节的总个数
                // (replaceCount[i] - replaceCount[j])：一个循环节中s2的个数
                //repeat：所有循环节中s2的总个数
                int repeat = ( (n1 - (j+1)) / (i - j) ) * (replaceCount[i] - replaceCount[j]);
                //末尾，不足以构成循环节的部分，含有的s2的数量
                int remain = replaceCount[j + (n1-(j+1)) % (i-j)] - replaceCount[j];
                return (preCount + repeat + remain) / n2;
            }
        }
        return replaceCount[n1] / n2;
    }

    @Test
    public void test() {
        System.out.println(getMaxRepetitions("aaa",2,"aa",1));
    }
}
