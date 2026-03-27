/**
 * Problem: LeetCode 33 - Search in Rotated Sorted Array
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * * Approach: Modified Binary Search (One-Pass)
 * Why: Even in a rotated sorted array, one half (either left or right) 
 * is always strictly sorted. We identify the sorted half and check if 
 * the target lies within its range.
 * 
 * * Time Complexity: O(log N) - Standard binary search performance.
 * Space Complexity: O(1) - No extra space used.
 */

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Identify which half is sorted
            // Case 1: Left half [left...mid] is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Target is in the sorted left half
                } else {
                    left = mid + 1;  // Target is in the right half
                }
            } 
            // Case 2: Right half [mid...right] is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Target is in the sorted right half
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }

        return -1; // Target not found
    }
}