import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class P381_O1时间插入删除和获取随即元素允许重复 {
    ArrayList<Integer> data;
    HashMap<Integer, HashSet<Integer>> map;
    /** Initialize your data structure here. */
    public P381_O1时间插入删除和获取随即元素允许重复() {
        data = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) map.put(val, new HashSet<>());
        map.get(val).add(data.size());
        data.add(val);
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0) return false;
        int removeIndex = map.get(val).iterator().next();
        map.get(val).remove(removeIndex);
        int last = data.get(data.size()-1);
        data.set(removeIndex, last);
        map.get(last).add(removeIndex);
        map.get(last).remove(data.size()-1);
        data.remove(data.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();
        int index= random.nextInt(data.size());
        return data.get(index);
    }

    @Test
    public void test() {
        P381_O1时间插入删除和获取随即元素允许重复 p = new P381_O1时间插入删除和获取随即元素允许重复();
        for (int i = 0; i < 5000; i++) {
            p.insert(i);
        }
        System.out.println(p.getRandom());
        System.out.println(p.getRandom());
    }
}
