public class BalancedBinaryTree {
    // ********************** LEETCODE PROBLEM 110 *****************************

/*
    // check if root is null, true

    // check if root has a left and right subtree,

    // get left subtree height

    // get right subtree height

    // if left height - right height > 1 , return false. else return true



    HOW to find height of subtree:
    // do traversal of all nodes

    // post order may give height?? Note: figured out you must do preorder count++ since
    // post wont "pass down" correct count of height

    // add count once you hit a post order since you cant go deeper

    // so
        left()
        right()
        now add count++ for height since it cant go deeper
*/
import java.lang.Math;

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null) {return true;}

            int[] flags = {0,0}; //left[0] and right[1]

            findSubtreeHeight(root.left, 0, flags, 0);
            findSubtreeHeight(root.right, 0, flags, 1);

            if(Math.abs(flags[0]-flags[1]) > 1) {return false;}
            else {return true;}

        }

        public void findSubtreeHeight(TreeNode node, int currentCount, int[] flags, int indexFlag){
            if(node == null){ return; }

            currentCount++;

            findSubtreeHeight(node.left, currentCount, flags, indexFlag);
            findSubtreeHeight(node.right, currentCount, flags, indexFlag);

            if(currentCount > flags[indexFlag]) {
                flags[indexFlag] = currentCount;
            }

            return;
        }
    }
}
