/**
 * Problem: LeetCode 347 - Top K Frequent Elements
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * * Approach: Min-Heap (Priority Queue)
 * Why: By maintaining a Min-Heap of size K, we ensure that the elements with
 * the lowest frequencies are removed, leaving only the K most frequent elements.
 * 
 * * Time Complexity: O(N log K) - N to build map, N log K to maintain heap of size K.
 * Space Complexity: O(N + K) - To store the frequency map and the heap.
 */

import java.util.*;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build frequency map O(N)
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-Heap to keep Top K elements
        // (a, b) -> a.getValue() - b.getValue() makes it a Min-Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        // Step 3: Iterate through map and push to heap O(N log K)
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the element with the smallest frequency
            }
        }

        // Step 4: Extract the Top K elements O(K log K)
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}