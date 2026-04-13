/**
 * Problem: Subtree of Another Tree
 * Link: https://leetcode.com/problems/subtree-of-another-tree/
 *
 * Type: Binary Tree
 * Approach: DFS + Tree Comparison
 *
 * Why:
 * At each node, we check if the subtree matches subRoot.
 * If not, recursively check left and right subtrees.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(h)
 */

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        // Check if current trees match
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Otherwise check left and right
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}