// def use sliding window to "increase size" of the longest substring

// you can keep track while using a set hash table to check
// if the character has repeated at all during the sliding window

// i would think you can keep increasing the size of window rightside way
// as long as no duplicates, keep checking and accounting for set
// when it finds duplicate... remove leftside AND keep track of set
// map while making sure no duplicate

// start k at 0 since length not started yet

// for int i until end of string length
    // k++
    // check if character in set
        // if so, remove a char from set (make sure to +1 to 
        // offset 0 indexing) and then decrease k (length of 
        // substring) by one until the current char i is gone from set
        // then re add current char to set and k++ too when adding back
    // if not, add to set
        // if k > maxLength, assign new max length


class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int maxK = 0;
        int k = 0;

        for(int i = 0; i < s.length(); i++){
            k++;
            char currChar = s.charAt(i);

            while(set.contains(currChar)){
                char removeChar = s.charAt(i - k + 1);
                set.remove(removeChar);
                k--;
            }
            set.add(currChar);

            if(k > maxK) { maxK = k;}
        }

        return maxK;
    }
}