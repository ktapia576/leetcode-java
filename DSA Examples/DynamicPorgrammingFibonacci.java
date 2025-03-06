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