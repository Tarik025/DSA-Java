/**
 * Problem: LeetCode 217 - Contains Duplicate
 * Link: https://leetcode.com/problems/contains-duplicate/
 * 
 * * Approach: HashSet for O(1) Average Lookups
 * Why: We use a Set to store elements as we traverse. If we encounter 
 * an element already in the Set, we've found a duplicate.
 * 
 * * Time Complexity: O(N) - We traverse the array once.
 * Space Complexity: O(N) - Worst case, all elements are unique and stored in the Set.
 */

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store visited numbers
        Set<Integer> visited = new HashSet<>();

        for (int num : nums) {
            // .add() returns false if the element is already present
            if (!visited.add(num)) {
                return true;
            }
        }

        return false;
    }
}