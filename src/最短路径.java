import org.junit.Test;

import java.util.*;
public class 最短路径 {
    //dijkstra最短路径算法，求单源最短路径，图中不能有负权边
    public void dijkstra(int[][] g, int n, int src) {
        int[] dis = new int[n];
        boolean[] visit = new boolean[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        for (int i = 0; i < n; i++) {
            int mark = i;
            for (int j = 0; j < n; j++) {
                if(!visit[j] && dis[j] < dis[mark]) {
                    mark = j;
                }
            }
            visit[mark] = true;
            for (int j = 0; j < n; j++) {
                if(!visit[j] && dis[j] > g[mark][j] + dis[mark]) {
                    dis[j] = g[mark][j] + dis[mark];
                }
            }
        }
        System.out.println(Arrays.toString(dis));
    }

    //floyd最短路径，求图中任意两点最短路径
    //dp[i][j][k]表示从i到j，只通过1-k节点，可得到的最短路径，递推公式：
    //dp[i][j][k] = math.min(dp[i][j][k-1]+dp[k][j][k-1], dp[i][j][k-1])
    //三重循环，由于每次计算dp，k只与之前k-1的状态关联， 将k放在最外层，每次计算时，dp存储k-1时的状态，因此可以将
    //三维数组 降维到二维
    public void floyd(int[][] g, int n) {
        int[][] dis = new int[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k]+g[k][j]);
                }
            }
        }
        for (int i = 0; i < dis.length; i++) {
            System.out.println(Arrays.toString(g[i]));
        }
    }



    @Test
    public void test() {
        int n = 5;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.MAX_VALUE >> 1;
            }
            a[i][i] = 0;
        }
        a[0][1] = 10;
        a[1][0] = 10;
        a[0][3] = 30;
        a[3][0] = 30;
        a[0][4] = 100;
        a[4][0] = 100;
        a[1][2] = 50;
        a[2][1] = 50;
        a[2][3] = 20;
        a[3][2] = 20;
        a[2][4] = 10;
        a[4][2] = 10;
        a[3][4] = 60;
        a[4][3] = 60;

        floyd(a,n);
    }

    public int mySqrt(int x) {
        int maxNum = 2;
        for(int i = 0; i < 4; i++) {
            maxNum *= maxNum;
        }

        for(int i = 0; i <= maxNum; i++) {
            long num = i * i;
            if(num > x) {
                return i - 1;
            }
        }

        return 0;
    }

    @Test
    public void test111() {
//        LinkedList<Integer> ans = new LinkedList<>();
//        ans.toArray(new int[0]);
//        int[] digits = new int[11];
//
//        LinkedList<Integer> ans = new LinkedList<Integer>(Arrays.asList(digits));
//        System.out.println(mySqrt(2147483627));

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.length()

//        String S = "123456";
//        S.substring()
//        minWindow("acbbaca" ,"aba");
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(2);
//        n1.next = n2; n2.next = n3;
//
//        deleteDuplicates(n1);

        int[] heights = {2,1,5,6,2,3};
        largestRectangleArea(heights);

    }

    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> heightStack = new LinkedList<>();
        LinkedList<Integer> heightIndexStack = new LinkedList<>();

        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++) {

            int newArea = heights[i];
            maxArea = Math.max(maxArea, heights[i]);

            if(!heightStack.isEmpty()) {

                if(heights[i] < heightStack.getLast()) {
                    if(heights[i] == 0) {
                        heightStack.clear();
                        heightIndexStack.clear();
                    }


                    for(int j = heightStack.size() - 1; j >= 0; j--) {
                        if(heightStack.get(j) >= heights[i]){
                            heightStack.set(j, heights[i]);
                        }else {
                            break;
                        }
                    }
                }

                for(int j = heightStack.size() - 1; j >= 0; j--) {
                    int w = i - heightIndexStack.get(j) + 1;
                    int h = heightStack.get(j);
                    maxArea = Math.max(maxArea, w * h);
                }
            }

            heightStack.addLast(heights[i]);
            heightIndexStack.addLast(i);
        }

        return maxArea;
    }


      class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }}

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode avaliable = new ListNode(-200);
        ListNode ans = avaliable;
        ListNode pre = head;
        ListNode node = head.next;
        boolean isAdd = true;


        while(node != null) {
            if(node.val != pre.val) {
                if(isAdd) {
                    avaliable.next = new ListNode(pre.val);
                    avaliable = avaliable.next;
                }
                isAdd = true;
            }else {
                isAdd = false;
            }
            pre = node;
            node = node.next;
        }

        if(isAdd) {avaliable.next = pre;}

        return ans.next;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> dirMap = new HashMap<Character, Integer>();
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        Map<Character, Integer> positionMap = new HashMap<>();


        for(Character c : charMap.keySet()) {
            indexMap.put(c, new ArrayList<Integer>());
        }

        for(int i = 0; i < s.length(); i++) {
            if(charMap.containsKey(s.charAt(i))) {
                dirMap.put(s.charAt(i), dirMap.getOrDefault(s.charAt(i), 0) + 1);
                indexMap.get(s.charAt(i)).add(i);
            }
        }

        if(charMap.size() != dirMap.size()) return "";

        for(Character c : charMap.keySet()) {
            if(dirMap.get(c) < charMap.get(c)) return "";
        }

        int minIndex = Integer.MAX_VALUE;
        int maxIndex = 0;

        for(Character c : charMap.keySet()) {
            minIndex = Math.min(minIndex, indexMap.get(c).get(0));
            maxIndex = Math.max(maxIndex, indexMap.get(c).get(charMap.get(c) - 1));
            positionMap.put(c, 0);
        }

        int ans = maxIndex - minIndex + 1;
        int start = minIndex;
        int end = maxIndex;

        while(true) {

            if(ans == t.length()) break;

            char minC = s.charAt(minIndex);

            // 有字符已经遍历结束了
            if(positionMap.get(minC) >= indexMap.get(minC).size() - charMap.get(minC)) break;

            int nextMaxIndex = indexMap.get(minC).get(charMap.get(minC) + positionMap.get(minC));
            if(nextMaxIndex >= maxIndex) {
                maxIndex = nextMaxIndex;
            }

            // 该字符坐标指针向后移动一位
            positionMap.put(minC, positionMap.get(minC) + 1);

            //重新选出minIndex
            minIndex = Integer.MAX_VALUE;
            for(Character c : charMap.keySet()) {
                minIndex = Math.min(minIndex, indexMap.get(c).get(positionMap.get(c)));
            }

            if(maxIndex - minIndex + 1 < ans) {
                start = minIndex;
                end = maxIndex;
                ans = maxIndex - minIndex + 1;
            }
        }
        return s.substring(start, end + 1);
    }
}

