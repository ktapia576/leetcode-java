public class PathSum {
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

visit each node and keep current sum... when traversing back up to root... subtract from current sum


function(node, targetSum, currentsum)

   // if node == null, return false since no path found

   // add current node to current sum

   // check if currentsum equals targetsum, if so return true

   // keep going left recursion

   // keep going right recusrion

   // if no left or right child, subtract current from current sum

   // return false since traversed all

/*



*/
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {

        }
    }
}
