/*
    This is a simple fibonacci program that calculate the fib number 
    at f(n), n being the index of the fibonacci sequence...

    0 1 1 2 3 5 8 13 21 ...

    This code solves for fib number by using a top down approach with recursion.
    However, a memo Hashmap table was added that uses a method called 
    memoization. 

    This made the code go from O(2^n) to O(n) !

    Its because memo map stores previously calculated fib numbers during the intial
    pass, "remembering" what fib (3) or f(4) equals as keys.

                fib(5)
               /      \
          fib(4)        fib(3)
          /    \        /    
     fib(3)   fib(2)  fib(2)
      /   \     /
    fib(2) fib(1) fib(1)
    /   
 fib(1)

Stored in memo:
f(2) = 1
f(3) = 2
f(4) = 3
f(5) = 5
f(6) = 8

So in "second" pass of the left or right subtree... it wont have to recalculate it

which essentially cuts off half the tree.. making it O(n) ! cool

Note: I used long instead of int because Java int is 32 bit signed which stores
too small of a range for a bigger fib number like 60

*/

import java.util.HashMap;

public class Main {
    static  HashMap<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("fib n: " + fib(60));
    }

    public static long fib(int n){
        if (n == 0) { return 0; }
        if (n == 1) { return 1; }

        // Check memoization table
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long result = fib(n-1) + fib(n-2);
        memo.put(n, result);
        return result;
    }
}