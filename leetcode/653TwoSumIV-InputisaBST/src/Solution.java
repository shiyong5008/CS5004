import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    public boolean findTarget(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int n = list.size();

        HashMap<Integer, Integer> map = new HashMap<>();

        /*
        for (int i = 0; i < n; i++) {
            map.put(i,list.get(i));
        }

        for (int i = 0; i < n; i++) {
            int target = k - map.get(i);
            for (int j = i+1; j < n; j++) {
                if (map.get(j) == target) {
                    return true;
                }
            }
        }
        return false;

         */

        for (int x : list) {
            if (map.containsKey(k - x)) {
                return true;
            }
            map.put(x, x);
        }
        return false;

    }

    public void inorder(TreeNode node, List<Integer> list) {

        if (node == null) return;

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);

    }

}