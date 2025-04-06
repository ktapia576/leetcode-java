// dynamic programming problem

// lests start with recursion: 

// two "branches" and we want to find the min cost

// lets find all possible solutions for now:

// the two choices are, you either go one step or two step!

/*

    NOTE: after coding realized it must be made into two trees maybe? since you have two different starting points.

    cost = [10,15,20]    output = 15

               0 --> this is where the "cost" starts, at 0
          /       \  you either take one or two steps
        10         15
       /  \       /  \
      25  30    25    top
     /  \  / \
    45     
   / \  
  top

    -- recursion first: start at cost 0

        -- base case: if steps >= cost.length;
            -- return totalCost;

        totalCost = totalCost + cost[steps]

        return Math.min( recurse(cost, totalCost, steps + 1), recurse(cost, totalCost, steps + 2))
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i-2], dp[i-1]);
        }

        return Math.min(dp[dp.length-2],dp[dp.length-1]);
    }
}

// tabulation with space optimization

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prevPrev = cost[0];
        int prev= cost[1];

        for(int i = 2; i < cost.length; i++) {
            int curr = cost[i] + Math.min(prevPrev, prev);
            prevPrev = prev;
            prev = curr;
        }

        return Math.min(prevPrev,prev);
    }
}


// MEMO RECURSION SOLUTION

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
    }

    public int minCost(int[] cost, int steps, HashMap<Integer, Integer> memo){
        if(steps >= cost.length) { return 0; }

        if(memo.containsKey(steps)) { return memo.get(steps);} 

        int result = cost[steps] + Math.min(minCost(cost, steps+1, memo), minCost(cost, steps+2, memo));

        memo.put(steps, result);

        return result;
    }