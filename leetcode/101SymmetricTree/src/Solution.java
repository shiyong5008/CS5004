import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        TreeNode l = root;
        TreeNode r = root;

        return check(l, r);

    }

    public boolean check(TreeNode l, TreeNode r) {

        if (l == null && r == null) return true;

        if (l == null || r == null) return false;

        return l.val == r.val && check(l.left, r.right) && check(l.right, r.left);


    }


    public boolean isSymmetric(TreeNode root) {

        TreeNode l = root;
        TreeNode r = root;

        return check(l, r);

    }

    public boolean check(TreeNode l, TreeNode r) {

        Queue<TreeNode> q = new LinkedList<>();

        if (l != null && r != null) q.add(l); q.add(r);

        while (!q.isEmpty()) {
            l=q.poll();
            r=q.poll();
            if (l == null && r == null) continue;
            if (l == null || r == null || l.val != r.val) return false;
            q.add(l.left);
            q.add(r.right);
            q.add(l.right);
            q.add(r.left);
        }

        return true;
    }

}
