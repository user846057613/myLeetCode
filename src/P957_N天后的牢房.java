import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class P957_N天后的牢房 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(Arrays.toString(cells) ,0);
        int[] newCells = new int[8];
        System.arraycopy(cells,0,newCells,0,8);
        newCells[0] = 0;
        newCells[7] = 0;
        int index = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 7; j++) {
                if(cells[j-1] == cells[j+1]) newCells[j] = 1;
                else newCells[j] = 0;
            }
            String s = Arrays.toString(newCells);
            if(map.containsKey(s)) {
                index = map.get(s);
                int left = (N - i) % (map.size()-index);
                index = index + left;
                break;
            }else{
                map.put(s,i);
                index = i;
                System.arraycopy(newCells,0,cells,0,8);
            }
        }
        String ans = "";
        for (String s : map.keySet()) {
            if(map.get(s) == index) {
                ans = s;
                break;
            }
        }
        int[] arrayAns = new int[8];
        int counter = 0;
        for (int i = 0; i < ans.length(); i++) {
            if(ans.charAt(i) == '0') arrayAns[counter++] = 0;
            else if(ans.charAt(i) == '1') arrayAns[counter++] = 1;
        }
        return arrayAns;
    }
}
