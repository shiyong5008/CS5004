import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {


            /*
            List<Integer> list = new ArrayList<>();
            TreeNode node = root;
            Stack<TreeNode> stack = new Stack<>();

            if (root == null) {
                return list;
            } else {
                while (!stack.isEmpty() || node != null) {
                    while (node != null) {
                        stack.push(node);
                        list.add(node.val);
                        node = node.left;
                    }
                    node = stack.pop();
                    node = node.right;
                }
            }
            return list;

             */

            List<Integer> list = new ArrayList<>();

            preorder(list, root);
            return list;


        }
        public void preorder(List<Integer> list, TreeNode node) {
            if (node == null) return;
            list.add(node.val);
            preorder(list, node.left);
            preorder(list, node.right);

        }
    }
}