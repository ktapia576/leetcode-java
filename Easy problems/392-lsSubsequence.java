// Iterate s string for every char and compare to each char in t iteratively

// duplicates can be ignored, since once you find a char you can just proceed to look for next char
// no matter what is in between the next char subsequence

// I implented the iterative approach in reverse because intially I wanted to add the subsequence
// into a stack and then compare... but I realized that was not needed since if a char was found
// and all other subsequennt chars in s were found (before running out of chars in t) then the 
// subsequence exists

// time: O(n)
// space: O(1)

// My second approach... Better than first and easier to read:

// starts from 0 instead of reverse, names the two pointers, removes result variable since not needed

class Solution {
    public boolean isSubsequence(String s, String t) {
        // no matter what if s.length() == 0, it will be true due to contraints that t will always be 0 or greater
        if(s.length() == 0) { return true; }  
        if(t.length() < s.length()) { return false; } // no matter what if you t is smaller than s, it wont have a subsequence

        // Find chars
        int sPointer = 0;
        for(int tPointer = 0; tPointer < t.length(); tPointer++){
            char currChar = t.charAt(tPointer);
            if(s.charAt(sPointer) == currChar) { 
                sPointer++;

                // if sIndex (found chars) equal s length, then all of s found in t before t ran out
                // s.length vs s.length-1 becasue sIndex starts at 0 which technically means it found a char
                // even though it didnt
                if(sPointer == s.length()) {return true;}
            }
        }

        return false;
    }
}