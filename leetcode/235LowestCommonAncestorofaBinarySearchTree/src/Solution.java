/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        return preoder(root, p, q);
    }

    public TreeNode preoder(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= root.val && q.val >= root.val) {
            return root;
        }
        else if (q.val < root.val) {
            return preoder(root.left, p, q);
        }
        else {
            return preoder(root.right, p, q);
        }
    }

}
