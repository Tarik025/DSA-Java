/**
 * Problem: Maximum Depth of Binary Tree
 * Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Type: Binary Tree
 * Approach: DFS (Recursion)
 *
 * Why:
 * For each node, depth = 1 + max(depth of left subtree, depth of right subtree)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // h = height of tree
 */

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        // Base case
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}