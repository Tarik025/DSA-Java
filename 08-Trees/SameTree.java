/**
 * Problem: Same Tree
 * Link: https://leetcode.com/problems/same-tree/
 *
 * Type: Binary Tree
 * Approach: DFS (Recursion)
 *
 * Why:
 * We compare both trees node by node.
 * Trees are same only if values match and structure is identical.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Case 1: both null → same
        if (p == null && q == null) {
            return true;
        }

        // Case 2: one null → not same
        if (p == null || q == null) {
            return false;
        }

        // Case 3: values differ → not same
        if (p.val != q.val) {
            return false;
        }

        // Recursively check left and right
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}