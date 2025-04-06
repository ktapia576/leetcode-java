// Essentially same as fibonacci BUT the "tree" has three leafs when solving recursively

/*
        4
    /    |     \
    1    2      3
             /  |  \
            0   1   2

    1+1+2 = 4

    base cases:
        trib(0) = 0
        trib(1) = 1
        trib(2) = 1

        return trib(n-3) + trib(n-2) + trib(n-1)

*/

class Solution {
    public int tribonacci(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();

        return trib(n, memo);

    }

    public int trib(int n, HashMap<Integer, Integer> memo){
        if (n == 0) { return 0; }
        if (n == 1 || n == 2) { return 1; }

        if(memo.containsKey(n)) { return memo.get(n); }

        int result = trib(n-3, memo) + trib(n-2, memo) + trib(n-1, memo);

        memo.put(n, result);

        return result;
    }
}

// Tabulation

class Solution {
    public int tribonacci(int n) {
        if (n == 0) { return 0; }
        if (n == 1 || n == 2) { return 1; }       

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        return dp[n];
    }
}

// SPACE OPTIMIZATION

class Solution {
    public int tribonacci(int n) {
        if (n == 0) { return 0; }
        if (n == 1 || n == 2) { return 1; }       

        int prevPrevPrev = 0;
        int prevPrev = 1;
        int prev = 1;
        int curr = 0;

        for(int i = 3; i <= n; i++){
           curr = prevPrevPrev + prevPrev + prev;
           prevPrevPrev = prevPrev;
           prevPrev = prev;
           prev = curr;
        }

        return curr;
    }
}