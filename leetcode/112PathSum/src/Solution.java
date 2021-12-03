import javax.swing.tree.TreeNode;

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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root != null) {
            if (root.left == null && root.right == null && targetSum == root.val) {
                return true;

            } else {
                int subSum = targetSum - root.val;
                return hasPathSum(root.left, subSum) || hasPathSum(root.right, subSum);

            }
        } else {
            return false;
        }
    }
}
