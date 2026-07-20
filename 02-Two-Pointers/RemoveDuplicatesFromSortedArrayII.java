/**
 * Problem: Remove Duplicates from Sorted Array II
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Type: Two Pointers
 *
 * Approach:
 * Maintain a write pointer that keeps the valid portion of the array.
 * The first two elements are always allowed.
 * For each remaining element, compare it with the element written
 * two positions before. If they are different, include the current
 * element in the valid array.
 *
 * Why:
 * Since the array is sorted, duplicate elements are adjacent.
 * Comparing with nums[write - 2] ensures that no element appears
 * more than twice in the resulting array.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {

        // Arrays with two or fewer elements are already valid
        if (nums.length <= 2) {
            return nums.length;
        }

        int write = 2;

        for (int read = 2; read < nums.length; read++) {

            // Keep the current element only if it doesn't create
            // more than two occurrences.
            if (nums[read] != nums[write - 2]) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;
    }
}