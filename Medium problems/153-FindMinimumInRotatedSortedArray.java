class Solution {
    public int findMin(int[] nums) {
        int lower = 0, higher = nums.length - 1;

        while (lower < higher) {
            int middle = lower + (higher - lower) / 2;
            
            // If mid element is less than the rightmost element,
            // that means the right half [mid..higher] is sorted.
            // Therefore, the rotation pivot (minimum) must be on the left side,
            // including mid itself → shrink search space to [lower..mid].
            if (nums[middle] < nums[higher]) {
                higher = middle;
            } 
            // If mid element is greater than nums[higher], 
            // that means the rotation point lies strictly to the right of mid.
            // So we can safely discard mid and everything to its left → move lower to mid + 1.
            else {
                lower = middle + 1; // +1 ensures shrink — avoids infinite loop
            }
        }

        // After convergence, lower == higher, pointing to the minimum element.
        return nums[lower];
    }
}
