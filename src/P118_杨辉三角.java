import java.util.ArrayList;
import java.util.List;

public class P118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 0) {
            return ans;
        }
        ans.add(new ArrayList<Integer>(){{add(1);}});
        if(numRows == 1) {
            return ans;
        }else{
            for (int i = 1; i < numRows; i++) {
                List<Integer> list = ans.get(i-1);
                List<Integer> newList = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    int num = 0;
                    if(j-1 >= 0 && j - 1 <list.size()){
                        num += list.get(j-1);
                    }
                    if(j >= 0 && j < list.size()) {
                        num += list.get(j);
                    }
                    newList.add(num);
                }
                ans.add(newList);
            }
        }
        return ans;
    }
}
