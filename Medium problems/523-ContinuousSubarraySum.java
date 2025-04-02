/*
 Use a hashmap approach with one pass.

 calculate prefix sum and then modulus it with k. If 0, then a factor of k, but store remainder in map for later use.

 if next elements remainder equals what is already in map, then that means if we subtract that "subarray" from the current

 index, that means it has to be a factor of k. Also make sure that the ith index - map's index > 2 length. That is why we store the index too

 example: 

    nums = [23,2,4,6,7], k = 6
    output = true

    prefixSum % k = remainder

    i=0: 23 % 6 = 5, not factor, store in map with index

    i=1: 25 % 6 = 1, not factor, store in map with index

    i=2: 29 % 6 = 5, not factor, already in map so that means we can "subtract" left array to get a factor of k!

    [23,2,4] not factor of k.

    remove [23] since that is in map with index, you get [2,4] which is a factor of k=6! 


    NOTE: make sure to always add the base case 0,-1 in map. because 0 is always a factor of k. so 0*0 works and 0*k works.
*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        for(int i =0; i < nums.length; i++){
            prefixSum += nums[i];

            int remainder = prefixSum % k;

            if(remainder == 0) { 
                return true;
            } else {
                map.put(remainder, i)
            }
        }

        return false;
    }
}