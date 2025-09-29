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

// SECOND ATTEMPT WITH A NEW KEY GENERATION STRATEGY, USING BITWISE SHIFT TO LEFT ONCE FOR FIRSTHOUSE
// NOT ROBBED SEQUENCE, AND UNIQUE KEY FOR FIRSTHOUSE IS ROBBED SEQUENCE.

class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();

        return helper(0, false, nums, memo);
    }

    public int helper(int houseIndex, boolean firstHouseStolen, int[] nums, Map<Integer, Integer> memo){
        if(houseIndex >= nums.length) {return 0;}
        if(firstHouseStolen && houseIndex == nums.length-1) {return 0;}

        //String key = houseIndex + "," + firstHouseStolen;

        // bitwise shift once to left to "make space" and then use an OR to add 1 or 0 to the flag 
        // bit if firsthouse robbed or not. faster than using Strings

        // maps to: (false, true) in relation to first house robbed
        // index 0 : (0,1)
        // index 1 : (2,3)
        // index 2 : (4,5)
        // index 3 : (6,7)

        int key = (houseIndex << 1) | (firstHouseStolen ? 0 : 1);

        if(memo.containsKey(key)){ return memo.get(key);}

        int currentHouse = nums[houseIndex];

        int skip = helper(houseIndex + 1, firstHouseStolen, nums, memo);

        boolean updateFirstHouseStolen = houseIndex == 0 || firstHouseStolen;
        int rob = helper(houseIndex + 2, updateFirstHouseStolen, nums, memo);

        int result = Math.max(skip, rob + currentHouse);
        memo.put(key, result);

        return result;
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


// Correct Tabulation approach with array O(n) time

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) { return nums[0];} 
        if(nums.length == 2) { return Math.max(nums[0], nums[1]);}

        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    public int robRange(int[] nums, int start, int end){
        int len = end - start + 1; // get length of subarray, inclusive, hence +1
        int[] arr = new int[len];
        
        arr[0] = nums[start];
        arr[1] = Math.max(nums[start], nums[start+1]);

        for(int i = 2; i < len; i++) {
            arr[i] = Math.max(arr[i-2]+nums[start+i], arr[i-1]);
        }

        return arr[arr.length-1];
    }
}



// Tabulation with O(1) space
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) { return nums[0];} 
        if(nums.length == 2) { return Math.max(nums[0], nums[1]);}

        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    public int robRange(int[] nums, int start, int end){
        int len = end - start + 1; // get length of subarray, inclusive, hence +1
        int[] arr = new int[len];
        
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start+1]);

        for(int i = 2; i < len; i++) {
            int currLoot = Math.max(prev2 + nums[start+i], prev1);
            prev2 = prev1;
            prev1 = currLoot;
        }

        return prev1;
    }
}


// 2D TABULATION THAT IS OVERKILL BUT COOL TO UNDERSTAND

// Below is the 2D approach to the solution. This makes the run O(n) vs O(2n) for non 2D solution. which still is O(n) for both solutions but gets rid of double linear pass vs 1D tabulation. 2D keeps track of two states: 

// dp[i][] keeps track of the house index.

// dp[i][f] keeps track of the parallel state, in a set f  —> {0,1}. 0 column = first house not taken, 1 column = first house taken,

// MAKE SURE TO SET THE BASES CASES CORRECTLY FOR EACH STATE/PARRALEL UNIVERSE

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) { return nums[0]; }
        if(nums.length == 2) { return Math.max(nums[0], nums[1]);}

        int[][] dp = new int[nums.length][2];
        
        // base cases for first house
        dp[0][0] = 0; // dont take first house
        dp[0][1] = nums[0]; // take first house

        // base cases for second house
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];

        for(int i = 2; i < nums.length; i++){
            int currentHouse = nums[i];
            dp[i][0] = Math.max(dp[i-1][0], currentHouse + dp[i-2][0]);

            // f=1: if at last house, only skip is allowed
            if (i == nums.length - 1) {
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
            }
        }

        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}