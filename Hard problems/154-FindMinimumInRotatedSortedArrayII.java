// First solution which works, but technically less strict and COULD potentially 
// get rid of possible min candidate within search space.. Also, harder to explain/ not conventional method
// This also doesnt have potential early exit.

class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1; 

        while( lo < hi) {
            int mid = lo + (hi - lo)/2;

            if(nums[lo] == nums[mid] && nums[mid] == nums[hi]){
                hi--;
                lo++;
            } else if (nums[mid] <= nums[hi]){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return nums[lo];
    }
}

// FAANG expected solution, that keeps it strict

/*

When nums[mid] == nums[hi], we can’t tell whether the minimum is on the left or right side — the array looks “flat” at both ends.
However, we know this for sure:

nums[hi] is not smaller than the true minimum (because it equals nums[mid]).

So by doing hi--, we remove one element (nums[hi]) that is definitely not smaller than any remaining candidate.
This:

Shrinks the search space

Guarantees we don’t discard the minimum

Preserves the invariant: “the minimum lies within [lo, hi]”


*/

class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1; 

        while( lo < hi) {
            // If the window is already sorted, the leftmost is the min.
            if(nums[lo] < nums[hi]) { return nums[lo]; }

            int mid = lo + (hi - lo)/2;

            if(nums[mid] < nums[hi]){
                // Min is at mid or on the left side.
                hi = mid;
            } else if (nums[mid] > nums[hi]){
                // Min is strictly to the right of mid.
                lo = mid + 1;
            } else {
                // nums[mid] == nums[hi] -> duplicates cause ambiguity; shrink hi safely.
                hi--;
            }
        }

        return nums[lo];
    }
}