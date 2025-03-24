// This is a DP problem

// Make this a recursion solution first then add hashmap with memo

// n is the number of steps to the top

// you can build from top down

// so if you have 2 steps

// you can subtract 1 step or 2 steps

// if the subtraction equals 0, then increment counter for the num of ways to climb stairs?

/* n = 2
            2
          /   \
        1      0
      /   \
    0      -1

    counter should be 2


    n = 3
                    3
                /       \
               2         1
             /   \      /   \ 
           1     0     0    -1
          /
         0

         3 ways


    n = 4
                    4
                /       \
               3         2
             /   \      /   \ 
           2      1     1     0
          / \    / \   / \
         1   0  0  -1  0  -1
        /
       0
         5 ways


         so this means you take 1 step backwards all the way.. and you also take 2 steps after... and you increment counter after reaching 0


         // base cases:
                if steps < 0 return 0
                if steps == 0 return 1 


                int counter = recurse(steps -1) + recurse(steps -2)
                

*/  

// this solution "retraces" steps, meaning going back down stairs top down approach with memo
class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return countSteps(n, memo);
    }

    public int countSteps(int n, HashMap<Integer, Integer> memo) {
        if (n < 0) {return 0;}
        if (n == 0) {return 1;}

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int result = countSteps(n-2, memo) + countSteps(n-1, memo); 
        memo.put(n, result);
        return result;
    }
}

/* RECURSION APPROACH MEMOIZATION ADD STEPS vs SUBTRACTING STEPS             */

class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return countSteps(0, n, memo);
    }

    public int countSteps(int steps, int n, HashMap<Integer, Integer> memo) {
        if (steps == n) {return 1;}
        if (steps > n) {return 0;}

        if(memo.containsKey(steps)){
            return memo.get(steps);
        }

        int result = countSteps(steps+2, n, memo) + countSteps(steps+1, n , memo); 
        memo.put(steps, result);
        return result;
    }
}


/* TABULATION METHOD BOTTOM UP APPROACH */

// tabulation approach

// Have arr be length of n+1 to index the array at nth steps... so index 4 will hold the num ways to get to 4 steps

// tabulation array for nth ways indexing --> [0,1,2,3,5] | arr[4] = 5 ways

// iterate through until you reach n steps
    // each time building up from previous steps based on indexing

// return arr[n]; for number of ways to nth steps

class Solution {
    public int climbStairs(int n) {
        if(n <= 2) { return n; } // return the base edge cases which the 1 and 2nd step are base starting points

        int[] arr = new int[n+1]; // arr defaults all indexes to 0
        arr[1]=1;
        arr[2]=2;

        for(int i = 3; i <= n; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }

        return arr[n];
    }
}


/* TABULATION METHOD SPACE OPTIMIZATION WITH TWO VARIABLES VS ARRAY */

class Solution {
    public int climbStairs(int n) {
        if(n <= 2) { return n; } // return the base edge cases which the 1 and 2nd step are base starting points

        int currSteps = 0;
        int twoStepsBefore = 1;
        int oneStepBefore = 2;

        for(int i = 3; i <= n; i++){
            currSteps = twoStepsBefore + oneStepBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = currSteps;
        }

        return currSteps;
    }
}