// Return TRUE if the path crosses itself at ANY point...

// so if the path repeats the same cordinates at ANY time it seems..

// how to keep track of when it crosses over previously visited path???

// Possible NAIVE solution:

// store cords in HashSet... if was previously visited.. return true
// if not, keep going until no more walking and then return false

class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> previouslyVisited = new HashSet<>();
        boolean pathsCrossed = false;

        // keep track of x and y
        int x = 0;
        int y = 0;

        // Add the staring to point to previously Visited before taking step
        previouslyVisited.add("0,0");

        for(int i = 0; i < path.length(); i++){
            char step = path.charAt(i);

            if(step == 'N') { y += 1; }
            if(step == 'S') { y -= 1; }
            if(step == 'E') { x += 1; }
            if(step == 'W') { x -= 1; }

            // convert to String
            String xCord = Integer.toString(x);
            String yCord = Integer.toString(y);
            String cordinate = xCord + "," + yCord;

            // Check if previusly visited cordinate
            if(previouslyVisited.contains(cordinate)){
                pathsCrossed = true;
                return pathsCrossed;
            } else {
                previouslyVisited.add(cordinate);
            }
        }

        return pathsCrossed;
    }
}