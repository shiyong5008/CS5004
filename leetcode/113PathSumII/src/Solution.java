import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        helper(root, targetSum);
        return lists;

    }

    public void helper(TreeNode root, int targetSum) {
        if (root == null) return;
        targetSum = targetSum - root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            lists.add(new ArrayList<>(list));
        }
        helper(root.left, targetSum);
        helper(root.right, targetSum);
        list.remove(list.size()-1);
    }

}