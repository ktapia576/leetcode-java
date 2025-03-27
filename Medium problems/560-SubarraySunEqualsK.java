/*
    HashMap solution with prefixSum and inversion cmombined.
    O(n) time
    O(n) space


    NAIVE SOLUTION: is a nested for loop, but then you are recalculating sub arrays.
    HashMap with prefix Sum stops that and lets you look up "previous" subarrays
    and count thier frequencies
    
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0,1);

        int currSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            int complement = currSum - k;

            if(prefixSums.containsKey(complement)) {
                count += prefixSums.get(complement);
            }
            
            if(prefixSums.containsKey(currSum)){
                int frequency = prefixSums.get(currSum);
                prefixSums.put(currSum, frequency+1);
            } else{
                prefixSums.put(currSum, 1);
            }
            
        }

        return count;
    }
}