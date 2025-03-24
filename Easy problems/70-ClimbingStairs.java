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