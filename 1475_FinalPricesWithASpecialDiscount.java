// this is question is similar to next greater or smaller element questions

// create a stack and use a for loop to iterate prices array for O(n)

// the stack will keep track of the indexes when we push or pop

// when we iterate thru the for loop, we check and every item in the stack... if it is not empty. 
// and we compare it to the current item... if current item is smaller than last item... that means
// last item's discount item is the current one in the for loop... so subtract stack item to current item and
// store result in the corresponding tracked index in stack... Some items may never be "popped" if no current item
// is smaller that the stored item in stack

class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = prices.clone();

        // stack to keep track of indices of previously iterate items
        Stack<Integer> previousItemIndices = new Stack<>();

        for(int i = 0; i < prices.length; i++){
            while(!previousItemIndices.isEmpty() && prices[(previousItemIndices.peek())] >= prices[i]){
                result[previousItemIndices.pop()] -= prices[i];
            }
            previousItemIndices.add(i);
        }

        return result;
    }
}