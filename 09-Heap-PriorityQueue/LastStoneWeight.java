/**
 * Problem: Last Stone Weight
 * Link: https://leetcode.com/problems/last-stone-weight/
 *
 * Approach: Max Heap (Priority Queue)
 *
 * Why:
 * We repeatedly need the two largest stones.
 * A max heap allows efficient retrieval of maximum elements.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        // Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        // Add all stones
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Smash stones until one or none remains
        while (maxHeap.size() > 1) {

            int first = maxHeap.poll();
            int second = maxHeap.poll();

            // If stones are different
            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        // Return remaining stone or 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}