/**
 * Problem: LeetCode 1 - Two Sum
 * Link: https://leetcode.com/problems/two-sum/
 * 
 * * Approach: One-pass Hash Map
 * Why: We trade space for time. By storing the complement (target - nums[i]) 
 * in a map, we can find the pair in constant time.
 * 
 * * Time Complexity: O(N) - We traverse the list once.
 * Space Complexity: O(N) - In the worst case, we store every element in the map.
 */

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Map to store: Key = Value, Value = Index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the complement exists in the map, we found our pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current number and its index
            map.put(nums[i], i);
        }

        // Return empty array if no solution is found (though LC guarantees one)
        return new int[] {};
    }
}