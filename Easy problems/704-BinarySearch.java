class Solution {
    public int search(int[] nums, int target) {
        int lower = 0, higher = nums.length-1;

        while(lower <= higher){
            // NOTE: you re-add "lower" so it fixes the correct index after 
            // finding out what "middle" would be doing higher - lower which
            // is essentially only finding the distance or how many indexes
            // to divide from

            // higher - lower gives what the distance or tick marks in between them.. and then dividing by two gives the middle
            // then adding lower readjusts it to make sure we "go back" to the correct subarray side
            int middleIndex = lower + (higher - lower)/2;

            if(target == nums[middleIndex]) {return middleIndex;}

            if(target < nums[middleIndex]){
                higher = middleIndex - 1; // subtract or add 1 to NOT include middle after check
            } else {
                lower = middleIndex + 1;
            }
        }

        return -1;
    }
}