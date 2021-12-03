import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }

     }




    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

         if (root == null) return "N,";
         String left = serialize(root.left);
         String right = serialize(root.right);
         return root.val + "," + left + right;

    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] str = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(str));

        return buildTree(list);

    }

    public TreeNode buildTree(List<String> list) {

         if (list.get(0).equals("N")) {
             list.remove(0);
             return null;
         }

         TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
         list.remove(0);
         node.left = buildTree(list);
         node.right = buildTree(list);

         return node;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
