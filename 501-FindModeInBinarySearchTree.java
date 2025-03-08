/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // create HashMap to hold counts of each node that appears

 // have maxFrequency counter to keep track of highest frequency,
 // since there can be more than 1 mode

 // how to keep track of max frequency???
 // find frequency by iterating through keySet and comparing the values

 // traverse the tree and update the map

 // once done traversing, iterate through map and check for all modes that
 // eqaul max frequency and update array


// This is one approach to solution vs an approach that has O(1) memory

// Time Complexities of this algo
// Time O(n)
// Space O(n)
class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();

        traverse(root, map);

        // iterate through hashmap and get modes with highest frequency

        // get max frequency
        int maxFreq = 0;
        for(int key : map.keySet()) {
            if(map.get(key) > maxFreq){
                maxFreq = map.get(key);
            }
        }

        // get all modes of max frequency store in arraylist
        ArrayList<Integer> modes = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxFreq) {
                modes.add(key);
            }
        }

        //convert list to int array
        int[] result = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;

    }

    public void traverse(TreeNode node, HashMap<Integer, Integer> map){
        if(node == null) {return;}
        
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        traverse(node.left, map);
        traverse(node.right, map);        
    }
}


// Iterative Approach that can replace recursion by implementing own stack

/*
       Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode node = stack.pop();

            map.put(node.val, map.getOrDefault(node.val, 0) + 1);

            if(node.left != null) { stack.push(node.left); }   
            if(node.right != null) { stack.push(node.right); }           
        }
*/

// BFS Approach that can replace iterative approach

/*
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            map.put(node.val, map.getOrDefault(node.val, 0) + 1);

            if(node.left != null) { queue.add(node.left); }   
            if(node.right != null) { queue.add(node.right); }           
        }
*/