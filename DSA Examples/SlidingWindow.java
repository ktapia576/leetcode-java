public class MaxSubarraySum {
    public static int maxSubarraySum(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        // Compute the sum of the first window
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        maxSum = currentSum;  // Initialize maxSum with the first window

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];  // Add new element, remove old element
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 5, 2, 8};
        int k = 3;
        System.out.println(maxSubarraySum(nums, k));  // Output: 15 (4+5+6)
    }
}