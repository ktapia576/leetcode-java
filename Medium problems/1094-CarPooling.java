// My inital solution using a points as a tracking interval array. 
// after reading the properties of each "trip/row" I update the points array
// by keeping track of how many passengers there are at a specific km/mileage point
// the km/mileage point is index based... so at 5km (index 5) can have however many passengers
// there are at that point in time. This is updated in the inner for loop using
// prefix sum array approach. Also keep track of the maxPassengers during the passes, 
// so that you dont have to iterate array again to find it.
// return whether maxpassengers is lesser than capacity.
// if true, that means we didnt go over capacity

// O(n x d) time: where d = end - start
// O(1) space

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] points = new int[1001];

        int maxPassengers = 0; 
        for(int row = 0; row < trips.length; row++){
            int numPassengers = trips[row][0];
            int startIndex = trips[row][1];
            int endIndex = trips[row][2];

            for(int i = startIndex; i < endIndex; i++)  { //make sure non inclusive. because you DROP OFF the passengers at endindex
                points[i] = points[i] + numPassengers;

                if(points[i] > maxPassengers) { maxPassengers = points[i]; }
            }
        }

        return maxPassengers <= capacity;
    }
}


// This solution uses points as a difference array. (It’s a form of event-based interval tracking )
// at the "start" index, you add the net change of passengers at that point
// at "end" you do the same thing... so when its "start" you add passengers
// when its "end" you subtract passengers... when current passengers exceed capacity
// return false

// O(n) time, does not do O(n x d) like first solution. Was so close! lol
// O(1) space

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] points = new int[1001];

        for(int row = 0; row < trips.length; row++){
            int numPassengers = trips[row][0];
            int startIndex = trips[row][1];
            int endIndex = trips[row][2];

            points[startIndex] = points[startIndex] + numPassengers;
            points[endIndex] = points[endIndex] - numPassengers;

        }

        // calculate current number of passengers using the difference array 
        // and the tracked net changes of which intervals 
        // passengers drop off or get picked up at,
        // if current higher than capacity, then return false
        int current = 0; 
        for(int i = 0; i < points.length; i++){
            current = current + points[i];

            if(current > capacity) return false;
        }

        return true;
    }
}

// SPACE OPTIMZED SOLUTION by creating points array using the MAX of the trips

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0; 
        for(int[] trip : trips){
            max = Math.max(max, Math.max(trip[1], trip[2])); // do both just in case user input error, prevents out of bounds index
        }

        int[] points = new int[max+1];

        for(int row = 0; row < trips.length; row++){
            int numPassengers = trips[row][0];
            int startIndex = trips[row][1];
            int endIndex = trips[row][2];

            points[startIndex] = points[startIndex] + numPassengers;
            points[endIndex] = points[endIndex] - numPassengers;

        }

        // calculate current number of passengers using the difference array 
        // and the tracked net changes of which intervals 
        // passengers drop off or get picked up at,
        // if current higher than capacity, then return false
        int current = 0; 
        for(int i = 0; i < points.length; i++){
            current = current + points[i];

            if(current > capacity) return false;
        }

        return true;
    }
}

// Using enhanced for loop for second array for more cleaner readable code

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0; 
        for(int[] trip : trips){
            max = Math.max(max, Math.max(trip[1], trip[2]));
        }

        int[] points = new int[max+1];

        for(int[] trip: trips){
            int numPassengers = trip[0];
            int startIndex = trip[1];
            int endIndex = trip[2];

            points[startIndex] = points[startIndex] + numPassengers;
            points[endIndex] = points[endIndex] - numPassengers;

        }

        int current = 0; 
        for(int i = 0; i < points.length; i++){
            current = current + points[i];
            if(current > capacity) return false;
        }

        return true;
    }
}