import javafx.util.Pair;

import java.util.*;

public class P218_天际线问题 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        if(buildings.length == 0) {
            return ans;
        }
        TreeSet<Pair<Integer,Integer>> pair = new TreeSet<>(
                new Comparator<Pair<Integer, Integer>>() {
                    @Override
                    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                        return o1.getKey().equals(o2.getKey()) ? o1.getValue() - o2.getValue():
                                o1.getKey() - o2.getKey();
                    }
                }
        );
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2-o1);
        for (int i = 0; i < buildings.length; i++) {
            pair.add(new Pair(buildings[i][0], -buildings[i][2]));
            pair.add(new Pair<>(buildings[i][1], buildings[i][2]));
        }
        int prev = 0;
        for (Pair<Integer, Integer> integerPair : pair) {
            if(integerPair.getValue() < 0) {
                queue.offer(-integerPair.getValue());
            }else {
                queue.remove(integerPair.getValue());
            }
            Integer cur = queue.peek() == null ? 0 : queue.peek();
            if(prev!= cur) {
                ans.add(new ArrayList<Integer>(){{
                    add(integerPair.getKey());
                    add(cur);
                }});
                prev = cur;
            }
        }
        return ans;
    }
}
