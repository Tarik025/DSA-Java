/**
 * Problem: Top K Frequent Elements
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Approach: Min Heap + Frequency Map
 *
 * Why:
 * We count frequencies using HashMap.
 * Then maintain a min heap of size k to keep the top k frequent elements.
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num,
                    frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(
                        (a, b) -> a.getValue() - b.getValue()
                );

        // Step 3: Keep only top k frequent elements
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            minHeap.offer(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Build result
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}