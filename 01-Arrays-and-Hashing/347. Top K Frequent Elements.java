// https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // --- Step 1: Build a Frequency Map ---
        // Count the occurrences of each number.
        // O(N) time.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // --- Step 2: Use a Min-Heap of size K ---
        // This is the "Top K" pattern. We will build a Min-Heap
        // that stores [number, frequency] pairs.
        // The heap will be ordered by frequency (the smallest frequency at the top).
        
        // We use a lambda expression (a, b) -> a.getValue() - b.getValue()
        // to tell the PriorityQueue to compare entries based on their value (frequency).
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue()); //This line only creates an empty PriorityQueue with a rule (comparator). Nothing is stored yet.

        // --- Step 3: Populate the Heap ---
        // Iterate through our frequency map.
        // O(N log k) time, where N is the number of unique elements.
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) { // “map.entrySet() ka jo Set hai, usme jitne entries (key-value pairs) hain, unko ek ek karke variable `entry` me daalo.”

            minHeap.add(entry); 
            
            // If the heap size exceeds k, remove the element with the smallest frequency (the one at the top of the Min-Heap).
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // --- Step 4: Extract the Result ---
        // At this point, the heap contains exactly the K most frequent elements.
        // O(k log k) time.
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // We poll from the heap k times to get our final answer.
            // The key of the map entry is the number we want.
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}

