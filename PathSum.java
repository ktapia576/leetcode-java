public class PathSum {
    // ************* LEETCODE PROBLEM 112 ******************

    /*
   target sum 19
   current sum =  19

               5
           /       \
          4         9
       /    \     /   \
     2      10    7    4
       \    /         /
       6    3         1
      /
     1

visit each node in preorder traversal... subtract its current value from target when visiting next node.


function(node, targetSum)

   // if node == null, return false since root node can be empty

   // check if no child nodes, indicating its a leaf node. Then check if targetsum equals 0 when subtracting current
   // node value

    // visit left node and subtract current node value for next traversal check  of target sum

    // visit right node doing same as left.. but return an OR of the returns of these two recursive cases.
    // this means return true if there EXISTS a root to leaf path for target sum.

     */

    class Solution {
        public boolean hasPathSum(TreeNode node, int targetSum) {
            if (node == null) { return false; }

            if (node.left == null && node.right == null) {
                return targetSum - node.val == 0; //Only check if equals targtsum when is leaf node
            }

            return hasPathSum(node.left, targetSum - node.val) || hasPathSum(node.right, targetSum - node.val);
        }
    }

}
