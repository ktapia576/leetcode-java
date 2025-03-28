/*
 Rob max houses, make sure no adjacent

 [1,5,3,1,5]
 
 recursion: steal or no steal

 steal current house or steal next house?

 left = steal, move to next possible house |    right = no steal, onto next house

                    1
                /         \
             3              5       
           /   \          /   \
        5       1        1     3
       / \     /  \     / \    / \
                   5       5   5  1
                  / \         / \ / \
                                     5
                                    / \
 * make sure if you dont steal to not add the value ? *

  grab the max value when moving back up

  how to handle the state?

  add state? like boolean steal? 

   if steal then add the number to total loot

   make sure to add loot at right time to see if stolen or not

   maybe flip tree makes more sense


   // recursive state

    base cases:
       - if index >= nums.length , return 0;

       //recurse into no steal
       noStealLoot = recurse(index + 1, loot)

       // now loot this house and then go to next possible house
       currLoot += nums[index]
        stealLoot = recurse(index+2, currLoot) //steal loot from other decisions

        return Math.max(noStealLoot, stealLoot + currLoot);

*/

class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return breakInHouse(nums, 0, memo);
    }

    public int breakInHouse(int[] nums, int index, HashMap<Integer, Integer> memo) {
        if(index >= nums.length){ return 0;}
        
        if(memo.containsKey(index)){
            return memo.get(index);
        }

        // no steal first
        int noStealLoot = breakInHouse(nums, index+1, memo);

        // now steal current house
        int currHouseLoot = nums[index];
        int stealLoot = breakInHouse(nums, index+2, memo);

        int maxLoot = Math.max(noStealLoot, currHouseLoot + stealLoot);

        memo.put(index, maxLoot);

        return maxLoot;
    }
}

/* TABULATION APPROACH */

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){ return 0;}
        if(nums.length == 1){ return nums[0]; }
        if(nums.length == 2){ return Math.max(nums[0], nums[1]); }

        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < arr.length; i++){
            arr[i] = Math.max(arr[i-2] + nums[i], arr[i-1]);
        }

        return arr[nums.length-1];
    }
}

/* TABULATION APPROACH without Array */

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){ return 0; }
        if(nums.length == 1){ return nums[0]; }
        if(nums.length == 2){ return Math.max(nums[0], nums[1]); }

        int maxLootOfPrev2Houses = nums[0];
        int maxLootOfPrevHouse = Math.max(nums[0], nums[1]);
        int currLoot = 0;
        
        for(int i = 2; i < nums.length; i++){
            currLoot = Math.max(maxLootOfPrev2Houses + nums[i], maxLootOfPrevHouse);
            maxLootOfPrev2Houses = maxLootOfPrevHouse;
            maxLootOfPrevHouse = currLoot;
        }

        return currLoot;
    }
}