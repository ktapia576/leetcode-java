class Solution {
    public int searchInsert(int[] nums, int target) {
        int lower = 0, higher = nums.length; // [lower, higher)

        while( lower < higher){
            int middle = lower + (higher-lower)/2;

            if(nums[middle] == target){ return middle; }

            if(target > nums[middle]) { 
                lower = middle + 1; // increase by one since target greater and this index isnt in valid answer space anyway
            }
            else {
                higher = middle; // when index is higher, shrink window but keep it since we could end up adding target to this specific index
                // if all other elements are lower and then it reaches lower == higher.
                // if you try to visualize the window shrinking with the boundaries you can see it. 
            }
        }

        return lower;
    }
}