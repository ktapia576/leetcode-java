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

// HashSet store each node in here as object, this should only store "unique" objects based on reference not value

// loop through list, if current node in set, return true;

// if list ends, node.next == null, then false // no cycle


public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();

        ListNode curr = head;
        while(curr != null){
            if(visited.contains(curr)) { return true; }
            
            visited.add(curr);
            curr = curr.next;
        }

        return false;
        
    }
}