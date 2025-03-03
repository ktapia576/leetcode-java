// Two Arrays: prices array[i] and results array[i]
// in both arrays, the ith item has a order that must match with results array[i]

// Must find discount by traversing array at ith item, and finding the MINIMUM index
// where prices[j] is less than or equal to current ith item.

// Need a for loop to travers array, there can be duplicates

// need two for loops for two pointers i (current item) and j (looking for discount item)

// j will always be minimum index because if first prices[j] <= prices[i] condition meets,
// j was only incrementing by one all the time (which is going to the next item over in order)

// Psuedo code:
// --------------------------------------
// results array

// for loop prices array pointer i
//    - for loop for second pointer j
//        - if prices[j] <= prices[i] , true
//             - results array [i] = prices[i] - prices[j]
//        - else,
//             - keep going
//        - make sure to handle edge case if no discount found...
//     

// return results array

class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            result[i] = prices[i]; // default value just in case discount not found, discount will override
            for(int j = i + 1; j < prices.length; j++){
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return result;
    }
}