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