/**
 * Problem: LeetCode 21 - Merge Two Sorted Lists
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 * * Approach: Iterative with Dummy Node
 * Why: Using a 'dummy' node allows us to build the new list without 
 * worrying about the head being a special case. We simply attach 
 * the smaller of the two current nodes to our tail.
 * * Time Complexity: O(N + M) - We traverse both lists once.
 * Space Complexity: O(1) - we are re-linking existing nodes, not creating new ones.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Step 1: Create a dummy node to act as the starting point
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // Step 2: Compare nodes from both lists and attach the smaller one
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Step 3: Attach the remaining nodes of the non-empty list
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // The merged list starts from dummy.next
        return dummy.next;
    }
}