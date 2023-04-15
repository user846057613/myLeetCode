import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class P二叉树的左视角 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        TreeNode n1 = new TreeNode(78);
        TreeNode n2 = new TreeNode(36);
        TreeNode n3 = new TreeNode(106);
        TreeNode n4 = new TreeNode(67);
        TreeNode n5 = new TreeNode(81);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.left = n5;
        ArrayList<Integer> ans = solve(n1);
        for(int i = 0; i< ans.size(); i++) {
            System.out.println(ans.get(i) + " ");
        }
    }

    public static ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root != null) {
            HashMap<Integer, TreeNode> map = new HashMap<>();
            int level = 0;
            put(0,root,map);
            for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
                ans.add(entry.getValue().val);
            }
        }
        return ans;
    }
    public static void put(int level,TreeNode root, HashMap<Integer, TreeNode> map) {
        if(root != null) {
            if(!map.containsKey(level)) {
                map.put(level,root);
            }
            put(level+1, root.left, map);
            put(level+1, root.right, map);
        }
    }
}