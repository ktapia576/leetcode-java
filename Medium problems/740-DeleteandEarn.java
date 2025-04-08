/*
This problem is solved with a key trick involved...

Recognizing this is a house robber problem similarly

First trick is to create an array that has all the values in a key index pair and keep track of its frequencies

called a frequency array but also kind of like a basic super simple non space efficient hashmap lol

nums = [3,4,2]

so...  [0, 0, 1, 1, 1] 
        0  1  2  3  4

this helps break down the problem to a house robber problem when solving recursively

if you "take" the current index, you MUST skip the next index and the index before it...

BUT if you start at index 1.. you always skip previous index technically since you cant go BACKWARDS anyway to take

so when you take: index + 2 (and you add the current points you take)

when you skip: index + 1

then you just memoize and create basic base case for recursion style!

if(i >= points.length) { return 0; }

since you dont want to go out of bounds and you will return 0 because no points taken or earned

STEPS:

// find maxValue in nums array. This is to find out how large our array should be and to no accidentally get out of bounds index
   if we do maxValue +1... meaning if 999 points exits. we wont try to access 1000 since its not there

// populate the frequencies in the points[] array corresponding to the nums[i]. Showed this example above.

// create memo

// create recursion function with base cases
    - if index > points.lenght
        - return 0;

    - find out the result of "take" so recurse(index+2) + current points
    - find out the result of "skip" so recurse(index+1)

    return the max(take, skip)

    **make sure to implment memoization

*/


class Solution {
    public int deleteAndEarn(int[] nums) {
        // find maxVal for array creation
        int maxVal = 0; 
        for(int i = 0; i < nums.length; i++){
            if(maxVal < nums[i]) { maxVal = nums[i]; }
        }

        // create frequency array that will have each index == nums[i].
        int[] points = new int[maxVal+1];
        
        // populate array with the correct values and frequencies
        for(int num : nums){
            points[num] += num;
        }

        HashMap<Integer, Integer> memo = new HashMap<>();

        return find(points, 1, memo);
    }

    public int find(int[] points, int i, HashMap<Integer, Integer> memo){
        if(i >= points.length) { return 0; }

        if(memo.containsKey(i)) { return memo.get(i);}

        int take = find(points, i+2, memo) + points[i];
        int skip = find(points, i+1, memo);

        int result = Math.max(take, skip);
        
        memo.put(i,result);
        return result;
    }
}

// TABULATION APPROACH
class Solution {
    public int deleteAndEarn(int[] nums) {
        // find maxVal for array creation
        int maxVal = 0; 
        for(int i = 0; i < nums.length; i++){
            if(maxVal < nums[i]) { maxVal = nums[i]; }
        }

        // create frequency array that will have each index == nums[i].
        int[] points = new int[maxVal+1];
        
        // populate array with the correct values and frequencies
        for(int num : nums){
            points[num] += num;
        }

        int[] dp = new int[points.length];
        dp[0] = points[0];
        dp[1] = Math.max(points[0], points[1]);

        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-2]+points[i], dp[i-1]);
        }

        return dp[dp.length-1];
    }
}

// Space Optimized tabulation
// Time O(n)
// Space O(n) points array
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) { return 0; }
        if (nums.length == 1) { return nums[0]; }

        // find maxVal for array creation
        int maxVal = 0; 
        for(int i = 0; i < nums.length; i++){
            if(maxVal < nums[i]) { maxVal = nums[i]; }
        }

        // create frequency array that will have each index == nums[i].
        int[] points = new int[maxVal+1];
        
        // populate array with the correct values and frequencies
        for(int num : nums){
            points[num] += num;
        }

        int prevPrev= points[0];
        int prev = Math.max(points[0], points[1]);

        for(int i = 2; i < points.length; i++){
            int curr = Math.max(prevPrev + points[i], prev);
            prevPrev = prev;
            prev = curr;
        }

        return prev; // return previous because sometimes for loop never runs and curr might not update
    }
}