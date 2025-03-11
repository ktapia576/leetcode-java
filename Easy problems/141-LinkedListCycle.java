/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Maybe check if object reference was passed again??
// instead of checking value, check if the node reference has been visited in a set?? 

// HashSet store each node in there as object, this should only store "unique" objects based on reference not value

// loop through list, if current node in set, return true;

// if list ends, node.next == null, then false // no cycle

// this solution is O(n) and memory is O(n)

// 9 mins 32 secs solved

// ---------------------------------------------------------------------------

// maybe use a tortoise and hare approach if you dont want to use stack

// the hare will always be faster and one day catch up to tortoise if there is a cycle

// if hare ends up being NULL, no cycle detected

// tortoise and hare approach may make it O(n) and memory O(1) too so a little better

public class Solution {
    public boolean hasCycle(ListNode head) {
        // check edge cases if null. prevents null pointer exception
        if(head == null) { return false; }
        if(head.next == null) { return false; }

        // Setup turtle and hare scanario race
        ListNode turtle = head;
        ListNode hare = head.next.next;

        // Keep looping until hare reached null first or hare catches up to turtle. 
        // (You can probably remove the check for turtle == null since hare is ahead all the time anyway, 
        // we also checked head for null earlier)
        while(turtle != null && hare != null && hare.next != null){
            // if hare caught up to turtle with same object reference... means cycle.
            if(turtle == hare) { return true; }

            turtle = turtle.next;
            hare = hare.next.next;
        }

        return false;
        
    }
}