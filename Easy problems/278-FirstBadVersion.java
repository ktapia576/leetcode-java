/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


// THIS IS MONOTONIC SHRINK STRATEGY variant of binary search

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lower = 1, higher = n; // no need to convert to array, can treat it as one since it increments 1 by 1
        
        // stop the dividing of middle index once it reaches a single point, since no need to keep manipulating 
        // bounds once first bad found. this is guranteed because of how we manipulate bounds using middle index
        // explained below. Try to visualize
        while(lower < higher){
            int middle = lower + (higher - lower)/2;

            boolean isBad = isBadVersion(middle);

            if(isBad){ 
                higher = middle; // keep bad version always in 'window' , if first bad is the lower bound
                // this will ensure the window shrinks from right side until it equals the lower bound first bad version
                // since we do middle + 1 after every good, it gurantees it
            } else {
                lower = middle + 1; // gurantees that the GOOD version out of window and that hopefully
                // next version is bad, if not it keeps shrinking towards left until all goods gone.
            }
        }
        return lower; // can return higher or lower, since it reaches single point and we leave
        // while loop before the bounds are manipulated again
    }
}