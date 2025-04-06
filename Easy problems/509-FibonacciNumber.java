// f(0) = 0

// f(1) = 1

// 0, 1, 1, 2, 3, 5, 8, 13, 21

/*

    base case: 
        - if n <= 0 
            - return 0
        - if n == 1
            - return 1

    recurse(n-1) + recurse(n-2)

*/

class Solution {
    public int fib(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();

        return getFib(n, memo);
    }

    public int getFib(int n, HashMap<Integer, Integer> memo){
        if(n <= 0) { return 0;}
        if(n == 1) { return 1;}
        
        if(memo.containsKey(n)) { return memo.get(n);}

        int result = getFib(n-2, memo) + getFib(n-1, memo);

        memo.put(n, result);

        return result;
    }
}

// TABULATION

class Solution {
    public int fib(int n) {
        if(n <= 0) { return 0;}
        if(n == 1) { return 1;}
        
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i=2; i < dp.length; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }
}

// SPACE OPTIMIZATION
class Solution {
    public int fib(int n) {
        if(n <= 0) { return 0;}
        if(n == 1) { return 1;}
        
        int prev = 1;
        int prevPrev = 0;
        int curr = 0;

        for(int i=2; i <= n; i++){
            curr = prev + prevPrev;
            prevPrev = prev;
            prev=curr;
        }

        return curr;
    }
}