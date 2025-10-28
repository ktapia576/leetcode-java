// My first solution that works but a little harder to explain or convince 
// than more expected convential way below 

class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while( lo <= hi ){
            int mid = lo + (hi - lo)/2;

            if(target == nums[mid]) { return true; }

            if(nums[lo] == nums[mid] && nums[mid] == nums[hi]) { // breaks sorted side check, 
            //so just shrink window until this condition no longer exists or we find target
                lo++;
                hi--;
            }
            else if(nums[mid] <= nums[hi]){ // right side sorted
                if(nums[mid] <= target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if(nums[lo] <= target && target <= nums[mid]) { // left side sorted
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return false;
    }
}

// FAANG expected answer that is easier to explain since when nums[mid] == nums[hi], 
// that means hi-- can be shrunk guranteed.

class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while( lo <= hi ){
            int mid = lo + (hi - lo)/2;

            if(target == nums[mid]) { return true; }

            if (nums[mid] < nums[hi]) {                // right half is strictly sorted
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid] > nums[hi]) {         // left half is strictly sorted
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {                                    // nums[mid] == nums[hi] -> duplicates ambiguity
                hi--;                                   // shrink safely; preserves correctness
            }
        }

        return false;
    }
}