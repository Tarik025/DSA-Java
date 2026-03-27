/**
 * Problem: Find Minimum in Rotated Sorted Array
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Approach: Binary Search
 *
 * Why:
 * The array is sorted but rotated.
 * One half is always sorted.
 * The minimum lies in the unsorted half.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // If mid is greater than right → min is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            else {
                // Min is in left half including mid
                right = mid;
            }
        }

        return nums[left];
    }
}