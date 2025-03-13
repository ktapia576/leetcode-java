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

/* O(n) time and O(1) space apporoach

this gets rid of HashSet usage by creating a seen array and leveraging
int range contraint

class Solution {
    public int distributeCandies(int[] candyType) {
        boolean[] seen = new boolean[200001]; // leveraging -105 <= candyType[i] <= 105, also defaults as false each index
        
        int uniqueCandy = 0, allowedCandy = candyType.length/2;

        for(int i=0; i < candyType.length;i++){
            int seenIndex = candyType[i] + 100000; // convert negatives to positive number index
            if(!seen[seenIndex]){
                seen[seenIndex] = true;
                uniqueCandy++;
                if(uniqueCandy > allowedCandy){ break; }
            }
        }
        // if unique candy is smaller that means reutrn that since Alice cant have more candy
        // even if she wanted to... return allowed candy if unique candy is larger since
        // Alice cant have more candy than allowed anyway
        return Math.min(allowedCandy, uniqueCandy); 
    }
}


*/