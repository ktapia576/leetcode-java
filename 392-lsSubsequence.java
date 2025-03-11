// Iterate s string for every char and compare to each char in t iteratively

// duplicates can be ignored, since once you find a char you can just proceed to look for next char
// no matter what is in between the next char subsequence

// I implented the iterative approach in reverse because intially I wanted to add the subsequence
// into a stack and then compare... but I realized that was not needed since if a char was found
// and all other subsequennt chars in s were found (before running out of chars in t) then the 
// subsequence exists

// time: O(n)
// space: O(1
class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean result = false;

        if(s.length() == 0) { return true; }   // no matter what if s.length() == 0, it will be true due to contraints that t will always be 0 or greater
        if(t.length() < s.length()) { return false; } // no matter what if you t is smaller than s, it wont have a subsequence

        // Find chars
        int sIndex = s.length()-1;
        for(int i = t.length()-1; i >= 0; i--){
            char currChar = t.charAt(i);
            if(s.charAt(sIndex) == currChar) { 
                if(sIndex-1 >= 0) {sIndex--;}
                else{ 
                    result = true; 
                    break;
                }
            }
        }

        return result;
    }
}