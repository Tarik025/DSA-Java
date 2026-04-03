/**
 * Problem: Invert Binary Tree
 * Link: https://leetcode.com/problems/invert-binary-tree/
 *
 * Type: Binary Tree
 * Approach: DFS (Recursion)
 *
 * Why:
 * For every node, we swap its left and right children recursively.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // h = height of tree
 */

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        // Base case
        if (root == null) {
            return null;
        }

        // Swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}