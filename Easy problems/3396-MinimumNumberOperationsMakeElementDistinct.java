// first check if all numbers distinct with set?

// then start removing 3 elements until they are all distinct

// icrement count after doing this

class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        int index = 0;
        while(!isDistinct(nums, index)){
            count++;
            index += 3;
        }

        return count;
    }

    public boolean isDistinct(int[] nums, int start) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = start; i < nums.length; i++){
            if(set.contains(nums[i])) { return false; }
            else { set.add(nums[i]); }
        }

        return true;
    }
}

// Reverse Traversal approach with flag array. not needed later
class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        boolean[] flags = new boolean[nums.length];

        for(int i = nums.length-1; i>= 0; i--){
            if(set.contains(nums[i])) { break; }
            else{ 
                flags[i] = true;
                set.add(nums[i]);
            }
        } 

        int count = 0;
        for(int i = 0; i<nums.length; i+=3){
            if(flags[i] == true) { break;}
            else { count++; 
            System.out.println(count);
            }
        }

        return count;
    }
}

// Solution without flags array and utlizing first time finding index with duplicate
// O(n) time, also stops extra for loop to "calculate" when the cutoff is
// O(n) space, hashset

class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int index = -1;
        for(int i = nums.length-1; i>= 0; i--){
            if(set.contains(nums[i])) { 
                index = i;
                break; }
            else{ 
                set.add(nums[i]);
            }
        } 

        return (index+3)/3; // get the ceiling calcuation for the index
    }
}