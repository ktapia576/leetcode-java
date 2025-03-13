// my first approach is to iterate through array once and add it to a set
// this is to keep track of individual type of candies

// for loop through array
    //check if item in set
    // if not store in set


// once done, take size of set
// calculate n by taking candyType.length/2

// take n % set.size()

// this solution is O(n) time
// O(n) space


class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        int allowedCandy = candyType.length/2;

        for(int i=0; i < candyType.length;i++){
            set.add(candyType[i]);
            if(set.size() > allowedCandy) { break;} // hopefully leave early if enough candyTypes found
        }

        if(allowedCandy >= set.size()) { return set.size(); }
        else { return allowedCandy; } 
    }
}