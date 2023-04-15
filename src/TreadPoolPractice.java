import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreadPoolPractice {
    static class FixPoolDemo{
        private static Runnable getTread(final int i) {
            return new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            };
        }

        public static void main(String[] args) {
//            ExecutorService fixPool = Executors.newFixedThreadPool(5);
//            for (int i = 0; i < 10; i++) {
//                fixPool.execute(getTread(i));
//            }
//            fixPool.shutdown();
            int ncpus = Runtime.getRuntime().availableProcessors();
            System.out.println(ncpus);
        }
    }

    class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
    public boolean isValidBST(TreeNode root) {
        boolean result = false;
        if(root != null) {
           result  = verifyBST(null,null,root);
        }
        return result;
    }

    private boolean verifyBST(Integer min, Integer max, TreeNode root) {
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        boolean isLeftChild = true;
        boolean isRightChild = true;
        if(root.left != null) isLeftChild = verifyBST(min, root.val, root.left);
        if(root.right != null) isRightChild = verifyBST(root.val, max, root.right);
        return isLeftChild && isRightChild;
    }
}
