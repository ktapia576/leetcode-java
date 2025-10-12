// left and right pointer bounds

// check if end of array greater or equal to target
    // if equal to return array size
    // if smaller return 0 since no solution

// minLength = Integer.Max_Value
// currSum = 0;

// for loop to keep increasing right until we reach end of loop
    // currSum += nums[right];
    
    // while loop to keep decreasing left bounds as long as currSum > target
    // if no longer greater than target, then stop decreasing/moving left
    // bounds up, its the right bounds turn to move up...
        // currSum -= nums[left]
        // left++

        // check if length < minLength and assign new if found
        // if length == 1 return 1 immediatly no point in looking for 
        // smaller

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int currSum = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            currSum += nums[right];

            while(currSum >= target){
                int currLength = right - left + 1;

                minLength = Math.min(currLength, minLength);

                if(currLength == 1) { return 1; } // early termination
                
                currSum -= nums[left++]; // decrease window size
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
