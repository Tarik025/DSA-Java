/**
 * Problem: LeetCode 15 - 3Sum
 * Link: https://leetcode.com/problems/3sum/
 * 
 * * Approach: Sorting + Two Pointers
 * Why: Sorting allows us to use the two-pointer technique to find pairs that 
 * sum to the negative of our current element. It also makes skipping 
 * duplicate triplets efficient.
 * 
 * * Time Complexity: O(N^2) - O(N log N) for sorting + O(N^2) for nested loops.
 * Space Complexity: O(1) or O(N) depending on the sorting implementation.
 */

import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array to use two pointers and handle duplicates
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: Skip the same element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Step 3: Use Two Pointers for the remaining part of the array
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Step 4: Skip duplicates for the left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Sum is too small, move left pointer to increase it
                } else {
                    right--; // Sum is too large, move right pointer to decrease it
                }
            }
        }
        return result;
    }
}