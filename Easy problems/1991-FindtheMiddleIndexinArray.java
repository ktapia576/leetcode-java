// Solution with prefixSum array

class Solution {
    public int findMiddleIndex(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];

        for(int i = 0 ; i < nums.length; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        int totalSum = prefixSum[prefixSum.length-1];

        for(int i = 1; i < prefixSum.length; i++){
            int rightSum = totalSum - prefixSum[i];
            int leftSum = prefixSum[i-1];

            if(rightSum == leftSum) { return i-1;} // return middle index properly, we are working one index ahead in prefix sum array
        }

        return -1;
    }
}

// Solution without prefixSumArray and only using total sum after looping once and then recalculating the "leftSum"
// while looping to find middle index.

class Solution {
    public int findMiddleIndex(int[] nums) {

        int totalSum = 0;
        for(int i = 0 ; i < nums.length; i++){
            totalSum += nums[i];
        }

        int leftSum = 0; 
        for(int i = 0; i < nums.length; i++){
            int rightSum = totalSum - leftSum - nums[i]; //subtract the left side from the right side and subtract the middle index value too
            if(rightSum == leftSum) { return i;}
            
            leftSum += nums[i];
        }

        return -1;
    }
}