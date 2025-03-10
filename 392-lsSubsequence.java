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