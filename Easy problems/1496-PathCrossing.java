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

        // save moves for better organization and easier maintainability 
        // in future if additonal moves added, like diagonal
        HashMap<Character, int[]> moves = new HashMap<>();
        moves.put('N', new int[]{0, 1});
        moves.put('S', new int[]{0, -1});
        moves.put('W', new int[]{-1, 0});
        moves.put('E', new int[]{1, 0});

        // keep track of x and y
        int x = 0;
        int y = 0;

        // Add the staring to point to previously Visited before taking step
        previouslyVisited.add("0,0");

        for(int i = 0; i < path.length(); i++){
            char step = path.charAt(i);
            int[] move = moves.get(step);

            x += move[0];
            y += move[1];

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