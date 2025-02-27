// this is greedy algorithm approach

// sort both arrays, children and cookies

// since sorted least to greatest, just give the child in line the next smallest cookie they are satisfied with...

// if we loop entire cookie array and the current child does not get satisfied, end loop and tell other kids they will not be satisfied either
// since the current child cant be satisfied, that def means next child cant be either because the next child had GREATER greed than current.

// keep track of the children you gave cookeis to and return that

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cookiesGiven = 0;

        //sort cookies so that biggest cookies towards the end of array, so you give the next kid in line smallest one possible for thier greed factor
        Arrays.sort(g);
        Arrays.sort(s);

        // index trackers for cookies and children
        int currentChild = 0;
        int cookieIndex = 0;

        // loop children until you run out of children or cookies
        while(currentChild < g.length && cookieIndex < s.length){
            // check if cookie satisfies current child
            if(s[cookieIndex] >= g[currentChild]){
                cookiesGiven++; // could use one variable for this, but i kept as two to keep it simple and more descriptive
                currentChild++;
            }
            cookieIndex++;
        }


        return cookiesGiven;
    }
}