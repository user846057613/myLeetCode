import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class P380_常数时间插入删除和获取随即元素 {

    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public P380_常数时间插入删除和获取随即元素() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(list.size(),val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int lastElement = list.get(list.size() - 1);
        int index = map.get(val);
        map.put(lastElement, index);
        list.set(index, lastElement);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
