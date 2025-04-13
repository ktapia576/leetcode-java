// Recursion with Memo

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> memo = new HashMap<>();

        return find(triangle, 0, 0, memo);
    }

    public int find(List<List<Integer>> triangle, int row, int col, Map<String, Integer> memo ){
        if(row >= triangle.size()){ return 0; }

        String key = row + "," + col;

        if(memo.containsKey(key)) { return memo.get(key); }

        int oneDown = find(triangle, row + 1, col, memo);
        int nextDown = find(triangle, row + 1, col + 1, memo);

        int currVal = triangle.get(row).get(col);

        int result = Math.min(oneDown, nextDown) + currVal;

        memo.put(key, result);

        return result;
    }
}


// Tabulation with 2D array
// O(n^2) time
// O(n^2) space

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];

        // fill up base case row
        for(int i = 0; i < n; i++) {
            dp[n-1][i] = triangle.get(n-1).get(i); 
        }

        for(int row = n-2; row >= 0; row--){
            for(int col = 0; col < triangle.get(row).size(); col++){
                dp[row][col] = triangle.get(row).get(col) + Math.min(dp[row+1][col], dp[row+1][col+1]);
            }
        }

        return dp[0][0];
    }
}

// Tabulation with 1D array used vs 2D
// gets rid of space or memory that is not needed
// O(n^2) time
// O(n) space

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] dp = new int[n];

        // fill up base case row
        for(int i = 0; i < n; i++) {
            dp[i] = triangle.get(n-1).get(i); 
        }

        for(int row = n-2; row >= 0; row--){
            for(int col = 0; col < triangle.get(row).size(); col++){
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col+1]);
            }
        }

        return dp[0];
    }
}


// Tabulation IN PLACE
// gets rid of ALL EXTRA space or memory that is not needed
// O(n^2) time
// O(1) space

// NOTE: SLOWER THAN 1D ARRAY in REAL WORLD EXAMPLE...
// This is because the method overhead calls of LIST<> is slower
// than the speed of direct access of array.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for(int row = n-2; row >= 0; row--){
            for(int col = 0; col < triangle.get(row).size(); col++){
                int down = triangle.get(row+1).get(col);
                int downRight = triangle.get(row+1).get(col+1);

                triangle.get(row).set(col, triangle.get(row).get(col) + Math.min(down, downRight));
            }
        }

        return triangle.get(0).get(0);
    }
}