import java.util.*;

public class P347_前K个高频元素 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hs.put(nums[i], hs.getOrDefault(nums[i],0) + 1);
        }
        List<Integer>[] lists = new List[nums.length+1];
        for (Integer integer : hs.keySet()) {
            if(lists[hs.get(integer)] == null) {
                lists[hs.get(integer)] = new ArrayList<>();
            }
            lists[hs.get(integer)].add(integer);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = lists.length - 1; i >= 0 && ans.size() < k; i--) {
            if(lists[i] != null) {
                ans.addAll(lists[i]);
            }
        }
        return ans;
    }

    public List<Integer> topKFrequent1(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i],0) + 1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i).getKey());
        }
        return ans;
    }
}
