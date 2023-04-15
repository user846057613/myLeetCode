import org.junit.Test;

import java.util.*;

public class Attempt {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public String longestPalindrome(String s) {
        int maxLength = 0;
        if(s == null || s.length() == 0) return "";
        String result = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int length = 0;
            int offset = 0;
            while (i-offset >= 0 && i + offset < n) {
                if(s.charAt(i-offset) == s.charAt(i+offset)) {
                    length = offset == 0 ? length + 1 : length + 2;
                    offset++;
                }else {
                    break;
                }
            }
            if(length > maxLength) {
                maxLength = length;
                result = s.substring(i-offset+1, i+offset);
            }
            int l = i, r = i + 1;
            offset = 0;
            length = 0;
            while (l-offset >= 0 && r+offset < n) {
                if(s.charAt(l-offset) == s.charAt(r+offset)) {
                    length += 2;
                    offset++;
                }else{
                    break;
                }
            }
            if(length > maxLength) {
                maxLength = length;
                result = s.substring(i-offset+1, i+1+offset);
            }
        }
        return result;
    }

    public int steal(int[] num) {
        if(num == null || num.length == 0) {
            return 0;
        }
        int n = num.length;
        int[] dp = new int[n];
        dp[0] = num[0];
        if(n > 1){
            dp[1] = Math.max(num[0],num[1]);
        }
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + num[i]);
        }
        return dp[n-1];
    }

    public int largestRectangleArea(int[] ints) {
        if(ints == null || ints.length == 0) return 0;
        int n = ints.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
           while (stack.peek() != -1 && ints[stack.peek()] >= ints[i]) {
               ans = Math.max(ans, ints[stack.pop()] * (i - 1 - stack.peek()));
           }
           stack.push(i);
        }
        while (stack.peek() != -1) {
            ans = Math.max(ans, ints[stack.pop()] * (n - 1 - stack.peek()));
        }
        return ans;
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],false);
        }
        int ans = 0;
        for (Integer integer : map.keySet()) {
            if(!map.get(integer)) {
                int cur = 1;
                int num = integer+1;
                while (map.containsKey(num)) {
                    cur++;
                    map.put(num,true);
                    num++;
                }
                ans = Math.max(ans,cur);
            }
        }
        return ans;
    }

    public int[] dailyTemperatures(int[] T) {
        if(T.length == 1) return new int[]{1};
        int n = T.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            int temp = T[i];
            int indexPre = i;
            while (!stack.isEmpty() && T[stack.peek()] <= temp) {
                stack.pop();
            }
            if(!stack.isEmpty()) indexPre = stack.peek();
            int dis = indexPre - i;
            ans[i] = dis;
            stack.push(i);
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) return ans;
            if(i-1 >= 0 && nums[i] == nums[i-1]) continue;
            int a = nums[i];
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = a + nums[left] + nums[right];
                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum > 0) right--;
                else if(sum < 0) left++;
            }
        }
        return ans;
    }

    public void flatten(TreeNode root) {
        if(root != null) {
            TreeNode node = root.right;
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            while (root.right != null) root = root.right;
            root.right = node;
            flatten(root.right);
        }
    }

//    public int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int n = nums.length;
//        HashSet<Integer>[] setArr = new HashSet[n+1];
//        for (int i = 0; i < nums.length; i++) {
//            if(map.containsKey(nums[i])) {
//                int index = map.get(nums[i]);
//                if(setArr[index + 1] == null) {
//                    setArr[index + 1] = new HashSet<>();
//                }
//                setArr[index + 1].add(nums[i]);
//                setArr[index].remove((Integer) nums[i]);
//                map.put(nums[i], index + 1);
//            }else {
//                if(setArr[1] == null) {
//                    setArr[1] = new HashSet<>();
//                }
//                setArr[1].add(nums[i]);
//                map.put(nums[i],1);
//            }
//        }
//        int[] ans = new int[k];
//        int cnt = 0;
//        for (int i = n; i >= 0; i--) {
//            if(cnt >= k) break;
//            if(setArr[i] == null) continue;
//            else {
//                for( Integer integer : setArr[i]) {
//                    ans[cnt] = integer;
//                    cnt++;
//                    if(cnt >= k) break;
//                }
//            }
//        }
//        return ans;
//    }

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

//    public int longestOnes(int[] arr, int k) {
//        if(arr.length == 0) return 0;
//        int n = arr.length;
//        int left = 0;
//        int right = 0;
//        int windowsLength = 0;
//        int windowsKNum = 0;
//        int ans = 0;
//        while (right < n) {
//            if(arr[right] == 1) {
//                windowsLength++;
//            }else {
//                while (windowsKNum >= k && left < right) {
//                    windowsLength--;
//                    if(arr[left++] == 0) windowsKNum--;
//                }
//                if(windowsKNum < k) {
//                    windowsKNum++;
//                    windowsLength++;
//                }else{
//                    left++;
//                }
//            }
//            right++;
//            ans = Math.max(ans, windowsLength);
//        }
//        return ans;
//    }
    public int longestOnes(int[] arr, int k) {
        if(arr.length == 0) return 0;
        int right = 0;
        int left = 0;
        int cnt = 0;
        while (right < arr.length) {
            if(arr[right++] == 0) cnt++;
            if (cnt > k && left < right) {
                if(arr[left++] == 0) cnt--;
            }
        }
        return right - left;
    }
    @Test
    public void test() {
//        System.out.println(longestPalindrome("babad"));
        int[] num = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(num,2).toArray()));
    }


}
