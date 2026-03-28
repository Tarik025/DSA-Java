/**
 * Problem: Reverse Linked List
 * Link: https://leetcode.com/problems/reverse-linked-list/
 *
 * Approach: Iterative (Pointer Manipulation)
 *
 * Why:
 * We reverse the direction of links one by one.
 * Use three pointers: prev, current, next.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next; // store next node

            current.next = prev; // reverse link

            prev = current; // move prev forward
            current = next; // move current forward
        }

        return prev;
    }
}