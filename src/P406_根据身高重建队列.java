import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P406_根据身高重建队列 {
    class People implements Comparable<People>{
        int h,k,p;
        public People(int h,int k,int p) {
            this.h = h;
            this.k = k;
            this.p = p;
        }
        @Override
        public int compareTo(People o) {
            if(this.p == o.p) {
                return this.h > o.h ? 1 : (this.h == o.h ? 0 : -1);
            }else {
                return this.p > o.p ? 1 : -1;
            }
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        if(people==null || people.length == 0) {
            return new int[0][2];
        }
        int[][] result = new int[people.length][2];
        List<People> peopleList = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            peopleList.add(new People(people[i][0], people[i][1]
            ,people[i][1]));
        }
        Collections.sort(peopleList);
        int index = 0;
        while (!peopleList.isEmpty()) {
            People p = peopleList.get(0);
            result[index][0] = p.h;
            result[index++][1] = p.k;
            peopleList.remove(0);
            for (int i = 0; i < peopleList.size(); i++) {
                People p2 = peopleList.get(i);
                if(p2.h <= p.h) {
                    p2.p--;
                }
            }
            Collections.sort(peopleList);
        }
        return result;
    }
}
