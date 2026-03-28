/**
 * Problem: Linked List Cycle
 * Link: https://leetcode.com/problems/linked-list-cycle/
 *
 * Approach: Floyd’s Cycle Detection (Tortoise & Hare)
 *
 * Why:
 * Use two pointers moving at different speeds.
 * If a cycle exists, they will meet.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) {
                return true; // cycle detected
            }
        }

        return false; // no cycle
    }
}