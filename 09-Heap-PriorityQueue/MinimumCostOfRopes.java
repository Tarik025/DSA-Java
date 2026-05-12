/**
 * Problem: Minimum Cost of Ropes
 * Link: https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
 *
 * Approach: Min Heap (Greedy)
 *
 * Why:
 * Always connect the two smallest ropes first
 * to minimize total cost.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    public long minCost(int[] arr) {

        // Min Heap
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        // Add all ropes into heap
        for (int rope : arr) {
            minHeap.offer((long) rope);
        }

        long totalCost = 0;

        // Continue until one rope remains
        while (minHeap.size() > 1) {

            long first = minHeap.poll();
            long second = minHeap.poll();

            long cost = first + second;

            totalCost += cost;

            // Add merged rope back
            minHeap.offer(cost);
        }

        return totalCost;
    }
}