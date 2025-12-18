package binary_trere_inorder_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode node(int val, TreeNode left, TreeNode right) {
        return new TreeNode(val, left, right);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }

    static void main() {
        IO.println(inorderTraversal(node(1, null, node(2, node(3, null, null), null))));
        IO.println(inorderTraversal(
            node(1,
                node(2,
                    node(4, null, null),
                    node(5,
                        node(6, null, null),
                        node(7, null, null)
                    )
                ),
                node(3, null,
                    node(8,
                        node(9, null, null),
                    null
                    )
                )
            )
        ));
        IO.println(inorderTraversal(null));
        IO.println(inorderTraversal(node(1, null, null)));
    }

}
