// this seems like a greedy algorithm approach

// Give the biggest cookie to the greediest kid... then give second biggest cookie to 2nd greediest kid etc...

// when you give a cookie, increment the total cookies given

//---------------------------------

// var maxCookies = 0;

// go through the g array (children wanting cookies, with g[i] corresponding to thier greed factor)

// keep track of cookie array, s, of which cookies were given. Give the biggest cookie to current kid in "line/queue"

// return maxCookies as answer

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cookiesGiven = 0;

        // Array to keep track of which cookies given using true or false flag. Default value is false
        boolean[] cookieGivenFlag = new boolean[s.length];

        //sort cookies so that biggest cookies towards the end of array, so you give the next kid in line smallest one possible for thier greed factor
        selectionSort(s);

        // go through each kid in "line"
        for(int i = 0; i < g.length; i++){
            // go through cookies and give them bigger or equal cookie to kid
            for(int j = 0; j < s.length; j++) {
                // if cookie equal to greed of kid, give kid cookie and mark as "given"
                if(s[j] >= g[i] && cookieGivenFlag[j] == false) {
                    cookieGivenFlag[j] = true;
                    cookiesGiven++;
                    break; //stop searching for more cookies for "same" kid
                }
            }
        }

        return cookiesGiven;
    }

    static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
          
            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                  
                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;           
        }
    }
}