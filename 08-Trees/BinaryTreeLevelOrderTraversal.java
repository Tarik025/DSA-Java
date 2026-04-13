/**
 * Problem: Binary Tree Level Order Traversal
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Type: Binary Tree
 * Approach: BFS (Queue)
 *
 * Why:
 * We use a queue to process nodes level by level.
 * At each level, we process all nodes currently in the queue.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size(); // number of nodes in current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}