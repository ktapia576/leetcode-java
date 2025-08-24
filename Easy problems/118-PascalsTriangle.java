/*
    dp approach with recursion

    first build the structure of the traingle OUTSIDE of recursion for easier understanding

    for row = 0; row < numRows   // rows < numRows because you only want the same number of rows that has been asked for
        for col = 0; col <= row    // col <= row because each row has same number of cols row 2 = 2 cols,  row 5 = 5 cols

    // this recursion builds the traingle from the top

       [1]   row 0
      [1,1]  row 1
     [1,2,1]
    [1,3,3,1]

    recursion:
        base cases:
            if (col == 0 || row == col) return 1  //since every first and last col of each row is equal to 1

            // add the previous row and previous col + previous row and curr col
            return recurse(row - 1, col - 1) + recuerse(row - 1, col) 


    example recursion for row 2 col 1:

    recurse(2,1) -- >   recurse(1,0) + recurse(1,1) == 2

    recurse(3,2) ---> recurse(2,1) + recurse(2,2) == 3
                        2          +       1      == 3

    // see how it builds off of first base case and builds down from top
*/


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for(int rowNum = 0; rowNum < numRows; rowNum++){
            List<Integer> row = new ArrayList<>();
            for(int col = 0; col <= rowNum; col++){
                row.add(pascalValue(rowNum, col));
            }
            triangle.add(row);
        }

        return triangle;
    }

    public int pascalValue(int row, int col){
        if(col == 0 || col == row) { return 1; }
        return pascalValue(row-1, col-1) + pascalValue(row-1, col);
    }
}

// RECURSION WITH MEMO
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        HashMap<String, Integer> memo = new HashMap<>();

        for(int rowNum = 0; rowNum < numRows; rowNum++){
            List<Integer> row = new ArrayList<>();
            for(int col = 0; col <= rowNum; col++){
                row.add(pascalValue(rowNum, col, memo));
            }
            triangle.add(row);
        }

        return triangle;
    }

    public int pascalValue(int row, int col, HashMap<String, Integer> memo){
        if(col == 0 || col == row) { return 1; }

        String key = row + "," + col;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = pascalValue(row-1, col-1, memo) + pascalValue(row-1, col, memo);

        memo.put(key, result);

        return result;
    }
}

// DP solution with DP TABLE no recursion

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for(int rowNum = 0; rowNum < numRows; rowNum++){
            List<Integer> row = new ArrayList<>();
            for(int col = 0; col <= rowNum; col++){
                //base cases
                if(col == 0 || col == rowNum) {
                    row.add(1);
                } else {
                    List<Integer> prevRow = triangle.get(rowNum-1);
                    int left = prevRow.get(col-1);
                    int right = prevRow.get(col);

                    row.add(left + right);
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}

// Recursion and Memo but with slightly better memo optimization... 2D arry vs HashMap
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        int[][] memo = new int[numRows][numRows]; // 0 == unset
        
        for(int row = 0; row < numRows; row++){
            List<Integer> wholeRow = new ArrayList<Integer>();
            for(int col = 0; col <= row; col++){
                int num = pascals(row, col, memo);
                wholeRow.add(num);
            }
            triangle.add(wholeRow);
        }

        return triangle;
    }

    public int pascals(int row, int col, int[][] memo){
        if (col < 0 || col > row) return 0;      // guard
        if(row == col) { return 1;}
        if(col == 0) { return 1;}

        if(memo[row][col] != 0) { 
            return memo[row][col];
        }
        
        int result = pascals(row-1, col-1, memo) + pascals(row-1, col, memo);
        memo[row][col] = result; 

        return result;
    }
}