import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P257_二叉树的所有路径 {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        List<String> ans = new ArrayList<>();
        if(root != null) {
            getAns(root, list, ans);
        }
        return ans;
    }

    private void getAns(TreeNode root, LinkedList<Integer> list, List<String> ans) {
          if(root != null) {
              list.add(root.val);
              if(root.left ==  null && root.right == null) {
                  StringBuilder sb = new StringBuilder();
                  for (int i = 0; i < list.size(); i++) {
                      if(i == 0) sb.append(list.get(i));
                      else sb.append("->" + list.get(i));
                  }
                  ans.add(sb.toString());
              }else {
                  getAns(root.left, list, ans);
                  getAns(root.right, list, ans);
              }
              list.removeLast();
          }
    }
}
