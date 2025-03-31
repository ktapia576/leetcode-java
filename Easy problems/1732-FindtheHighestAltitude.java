// prefix sum problem since we are looking at the highest gain in altitude

// since we get only the gains at each point.. we need to return the highest alititude

// to do that we need the sums of all prvious gains and then store the highest altitude after each gain


class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0; //start at 0 because next steps can keep going "down" and you have to start at 0 anyway, also problem states it

        int altitude = 0;
        for(int i = 0; i < gain.length; i++){
            altitude = altitude + gain[i];

            if(altitude>highestAltitude) { highestAltitude = altitude; }
        }
        return highestAltitude;
    }
}