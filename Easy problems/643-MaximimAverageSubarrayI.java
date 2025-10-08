class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // compute first window sum 
        long sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        long maxSum = sum;

        for(int j = k; j < nums.length; j++){
            sum += nums[j];
            sum -= nums[j - k];

            // only look for max sum since dividing it by k will give the "max avg" anyway
            if(sum > maxSum) { maxSum = sum; } 
        }

        return maxSum / (double) k;
    }
}