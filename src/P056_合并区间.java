import java.util.ArrayList;
import java.util.Collections;

public class P056_合并区间 {
    class Scope implements Comparable<Scope>{
        int start;
        int end;
        Scope(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Scope o) {
            if(start == o.start) {
                if(end == o.end) {
                    return 0;
                }else {
                    return end - o.end > 0 ? 1 : -1;
                }
            }else {
                return start - o.start > 0 ? 1 : -1;
            }
        }
    }

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return new int[intervals.length][2];
        }

        ArrayList<Scope> scopes = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            scopes.add(new Scope(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(scopes);
        ArrayList<Scope> result = new ArrayList<>();
        for (int i = 0; i < scopes.size(); i++) {
            Scope s = scopes.get(i);
            if(result.isEmpty()) {
                result.add(s);
            }else {
                boolean flag = true;
                int index = -1;
                for (int j = 0; j < result.size(); j++) {
                    Scope u = result.get(j);
                    if(s.start > u.end) {
                        continue;
                    }else if(s.start <= u.end && s.end <= u.end) {
                        flag = false;
                        break;
                    }else if(s.start <= u.end && s.end >= u.end) {
                        Scope scope = new Scope(u.start, s.end);
                        result.add(scope);
                        index = j;
                        flag = false;
                        break;
                    }
                }
                if( index != -1) {
                    result.remove(index);
                }
                if(flag == true) {
                    result.add(s);
                }
            }
        }
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            Scope s = result.get(i);
            ans[i][0] = s.start;
            ans[i][1] = s.end;
        }
        return ans;
    }
}
