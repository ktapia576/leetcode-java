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