// First solution using two lists O(n) space
// Not using a full dp table or "triangle" structure in code

class Solution {
    public List<Integer> getRow(int rowIndex) {
        // setup 1 row as "PrevRow" to start working on it
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);

        if(rowIndex == 0){ return prevRow; }
        
        for(int row = 0; row <= rowIndex; row++){
            List<Integer> currRow = new ArrayList<>();
            for(int col = 0; col <= row; col++){
                if(col == 0 || col == row){
                    currRow.add(1);
                } else {
                    int left = prevRow.get(col-1);
                    int right = prevRow.get(col);

                    currRow.add(left+right);
                }
            }
            prevRow = currRow;
        }
        return prevRow;
    }
}

// In place solution to Pascal's Triangle not needing two lists
// NOTE: must work from left to right due to nature of how DP tables work to not update
// "needed" values

//  the for loops will ONLY update the row and col it is working on, which makes this space
// optimization technique pretty cool

/*
row 0:    [1,0,0,0,0]
row 1:    [1,1,0,0,0]
row 2:    [1,2,1,0,0]
row 3:    [1,3,3,1,0]
row 4:    [1,4,6,4,1]
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> arr = new ArrayList<>();

        // default values and make arr size equal to rowindex. (This is because row 5 will have 5 cols, row 6 will have 6 cols)
        // pattern recognition
        for(int i = 0; i <= rowIndex; i ++){
            arr.add(0);
        }
        
        for(int row = 0; row <= rowIndex; row++){
            for(int col = row; col >= 0; col--){    // work from right to left, so we dont update values we need
                if(col == 0 || col == row){
                    arr.set(col,1);
                } else {
                    // grab previous values, the "left and right" values
                    int left = arr.get(col-1);
                    int right = arr.get(col);

                    arr.set(col, left+right);   // update current col with value, which doesnt update the next needed values
                }
            }
        }
        return arr;
    }
}