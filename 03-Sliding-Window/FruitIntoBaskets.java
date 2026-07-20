/**
 * Problem: 904. Fruit Into Baskets
 * Link: https://leetcode.com/problems/fruit-into-baskets/
 *
 * Approach: Sliding Window + HashMap
 * The problem reduces to finding the maximum length of a contiguous subarray
 * that contains at most 2 distinct integers.
 * 
 * We use two pointers (left and right) to represent our current window:
 * 1. Expand the window by moving the 'right' pointer and updating fruit counts in a HashMap.
 * 2. If the HashMap size exceeds 2, shrink the window from the 'left' until only 2 distinct types remain.
 * 3. Track the maximum window size (right - left + 1) at each valid state.
 *
 * Time Complexity: O(N)
 * Each element is added to and removed from the HashMap at most once, running in linear time.
 * 
 * Space Complexity: O(1)
 * The HashMap stores at most 3 distinct fruit types at any given time, taking constant memory.
 */

import java.util.HashMap;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {

        // Edge case: empty input or 2 or fewer trees (can pick all)
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        if (fruits.length <= 2) {
            return fruits.length;
        }

        // Step 1: Frequency map to track fruit types in current window
        HashMap<Integer, Integer> fruitCounts = new HashMap<>();

        int left = 0;
        int maxFruits = 0;

        // Step 2: Expand window using right pointer
        for (int right = 0; right < fruits.length; right++) {

            int incomingFruit = fruits[right];
            fruitCounts.put(incomingFruit, fruitCounts.getOrDefault(incomingFruit, 0) + 1);

            // Step 3: Shrink window when distinct fruit types exceed 2
            while (fruitCounts.size() > 2) {

                int outgoingFruit = fruits[left];
                fruitCounts.put(outgoingFruit, fruitCounts.get(outgoingFruit) - 1);

                // Completely remove fruit type when count drops to zero
                if (fruitCounts.get(outgoingFruit) == 0) {
                    fruitCounts.remove(outgoingFruit);
                }

                left++; // Slide left boundary forward
            }

            // Step 4: Update maximum yield for valid window
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        // Step 5: Return result
        return maxFruits;
    }
}