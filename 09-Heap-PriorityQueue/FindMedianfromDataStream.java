/**
 * Problem: Find Median from Data Stream
 * Link: https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Approach: Two Heaps
 *
 * Why:
 * Max Heap stores smaller half.
 * Min Heap stores larger half.
 * This allows efficient median retrieval.
 *
 * Time Complexity:
 * addNum() -> O(log n)
 * findMedian() -> O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.PriorityQueue;

public class FindMedianfromDataStream {

    // Max Heap -> stores smaller half
    private PriorityQueue<Integer> maxHeap;

    // Min Heap -> stores larger half
    private PriorityQueue<Integer> minHeap;

    public FindMedianfromDataStream() {

        maxHeap = new PriorityQueue<>((a, b) -> b - a);

        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Add to maxHeap
        maxHeap.offer(num);

        // Step 2: Move largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());

        // Step 3: Balance heaps
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        // If sizes different
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        // If sizes equal
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}