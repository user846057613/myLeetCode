import java.util.LinkedList;

public class P572_另一个树的子树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    String lNull = "lNull";
    String rNull = "rNull";
    public boolean isSubtree(TreeNode s,TreeNode t) {
        String sS = dfs(s);
        String tS = dfs(t);
        return kmp(sS,tS);
    }

    private boolean kmp(String s, String t) {
        int i = 0;
        int j = 0;
        int[] next = getNext(t);
        while (i < s.length() && j < t.length()) {
            if(j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == t.length()) {
            return true;
        }else{
            return false;
        }
    }

    private int[] getNext(String t) {
        int n = t.length();
        int[] next = new int[n];
        int j = 0;
        int k = -1;
        next[0] = -1;
        while (j < t.length()) {
            if(k == -1 || t.charAt(j) == t.charAt(k)) {
                if(t.charAt(++j) == t.charAt(++k)) {
                    next[j] = next[k];
                }else{
                    next[j] = k;
                }
            }else{
                k = next[k];
            }
        }
        return next;
    }

    private String dfs(TreeNode s) {
        if(s != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.val);
            sb.append(s.left == null ? lNull : dfs(s.left));
            sb.append(s.right == null ? rNull : dfs(s.right));
            return sb.toString();
        }else{
            return "";
        }
    }


    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if(t == null) return true;
        if(s == null) return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.val == t.val) {
                    if (validate(node,t)) return true;
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null ) queue.offer(node.right);
            }
        }
        return false;
    }

    private boolean validate(TreeNode node, TreeNode t) {
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(node);
        queue2.offer(t);
        while (!queue1.isEmpty()) {
            int size1 = queue1.size();
            int size2 = queue2.size();
            if(size1 != size2) return false;
            for (int i = 0; i < size1; i++) {
                TreeNode nodeS = queue1.poll();
                TreeNode nodeT = queue2.poll();
                if(nodeS == null && nodeT == null) continue;
                if(nodeS == null || nodeT == null) return false;
                if(nodeS.val != nodeT.val) return false;
                queue1.offer(nodeS.left);
                queue1.offer(nodeS.right);
                queue2.offer(nodeT.left);
                queue2.offer(nodeT.right);
            }
        }
        return true;
    }
}
