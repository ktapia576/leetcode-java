// this looks like a prefix sum problem

// maybe a mix of binary search??

// sorting does not work since the previous total is affected by current..

// meaning we can have -3, then have 50 or the highest number... and the min start value could be 4, 
// even though there might be a -20 later

// start half way??

// find prefix sum each 


//WAIT: sort the prefiox sum array?? find the LEAST value? and then just make that min start?? idk

class Solution {
    public int minStartValue(int[] nums) {
        int[] arr = new int[nums.length+1];

        // find prefix arr
        for(int i = 0; i < nums.length; i++){
            arr[i+1] = arr[i] + nums[i];
        }

        int leastValue = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < leastValue) { leastValue = arr[i]; }
        }

        if(leastValue < 1) {
            return Math.abs(leastValue) + 1;
        } else {
            return 1;
        }
    }
}

// after first submit, instead of sorting which may take O(n log n) or O(n^2) just iterate O(n) and get least Value
// sorting is overkill when just looking for a minimum

// This is a one pass solution without needing a prefix array since its not needed in return result
// you can calculate prefixSum in one variable and look for minimum step value same time.
// O(n) time
// O(1) space

class Solution {
    public int minStartValue(int[] nums) {
        int prefixSum = 0;
        int leastValue = Integer.MAX_VALUE;

        // calculate prefix and store the min prefix same time
        for(int i = 0; i < nums.length; i++){
            prefixSum = prefixSum + nums[i];
            if(prefixSum < leastValue) { leastValue = prefixSum; }
        }

        if(leastValue < 1) {
            return Math.abs(leastValue) + 1;
        } else {
            return 1;
        }
    }
}