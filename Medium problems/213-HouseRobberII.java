/*

[5,2,4,6,10]
output = 14

     5
  /    \
10       2
  \      /      
   6 - 4   


   5 steal or no steal ---> no steal since previous house more??

    //Recursive solution:

    base cases:
        if index > nums.length, return 0
        if firstHouse stolen == true && index == nums.length-1, return 0

        // no steal
        int noStealLoot= recurse(nums, index+1,firstHouseStolen) // should be false

        currLoot = nums[index];
        firstHouseStolen = true;

        // steal
        int stealLoot = recurse(nums, index+2, firstHouseStolen)

        return max(noStealLoot, stealLoot + currLoot)


*/

// RECURSION WITH MEMOIZATION METHOD

class Solution {
    public int rob(int[] nums) {
        HashMap<String, Integer> memo = new HashMap<>();
        return breakInHouse(nums, 0, false, memo);
    }

    public int breakInHouse(int[] nums, int index, boolean firstHouseStolen, HashMap<String, Integer> memo) {
        if(index >= nums.length) { return 0;}
        if(index == nums.length-1 && firstHouseStolen) { return 0;}
        
        String key = index + "_" + firstHouseStolen;

        if(memo.containsKey(key)) { return memo.get(key); }

        // no steal
        int skipMaxLoot = breakInHouse(nums, index+1, firstHouseStolen, memo);

        // steal
        int currLoot = nums[index];
        boolean updateFirstHouseStolen = (index == 0) ? true : firstHouseStolen;

        int robMaxLoot = breakInHouse(nums, index+2, updateFirstHouseStolen, memo);

        int maxLoot = Math.max(skipMaxLoot, currLoot + robMaxLoot);

        memo.put(key, maxLoot);

        return maxLoot;
    }
}

// MY FIRST ATTEMPT AT TABULATION

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) { return nums[0];} 
        if(nums.length == 2) { return Math.max(nums[0], nums[1]);}

        int[] robFirstHouseTabulation = new int[nums.length];
        robFirstHouseTabulation[0] = nums[0];
        robFirstHouseTabulation[1] = nums[0];

        int[] skipFirstHouseTabulation = new int[nums.length];
        skipFirstHouseTabulation[0] = 0;
        skipFirstHouseTabulation[1] = nums[1];

        // only compute tabulation up to the n-1th house since we cant steal last house anyway since first house stolen
        for(int i = 2; i < nums.length-1; i++){
            robFirstHouseTabulation[i] = Math.max(robFirstHouseTabulation[i-2] + nums[i], robFirstHouseTabulation[i-1]);
        }


        for(int i = 2; i < nums.length; i++){
            skipFirstHouseTabulation[i] = Math.max(skipFirstHouseTabulation[i-2] + nums[i], skipFirstHouseTabulation[i-1]);
        }
        

        return Math.max(robFirstHouseTabulation[nums.length-2],skipFirstHouseTabulation[nums.length-1]);
    }
}