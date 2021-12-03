import java.util.*;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return lists;

        q.add(root);

        boolean leftToRight = true;
        while (!q.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int n = q.size();

            for (int i = 0; i < n; ++i) {

                TreeNode node = q.poll();
                if (leftToRight) {
                    list.add(node.val);
                } else {
                    list.addFirst(node.val);
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

            }

            lists.add(list);
            leftToRight = !leftToRight;

        }

        return lists;

    }
}
