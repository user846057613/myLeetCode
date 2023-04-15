import java.util.ArrayList;
import java.util.HashMap;

public class P350_两个数组的交集Ⅱ {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            mp.put(nums1[i], mp.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if(mp.containsKey(nums2[i]) && mp.get(nums2[i]) > 0) {
                mp.put(nums2[i], mp.get(nums2[i])-1);
                ans.add(nums2[i]);
            }
        }
        int[] trans = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            trans[i] = ans.get(i);
        }
        return trans;
    }
}
