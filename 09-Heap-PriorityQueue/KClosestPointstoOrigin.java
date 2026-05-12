/**
 * Problem: K Closest Points to Origin
 * Link: https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Approach: Max Heap (Priority Queue)
 *
 * Why:
 * We maintain a max heap of size k.
 * If heap size exceeds k, remove the farthest point.
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */

import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int k) {

        // Max Heap based on distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> distance(b) - distance(a)
        );

        for (int[] point : points) {

            maxHeap.offer(point);

            // Keep only k closest points
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    // Calculate squared distance from origin
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}