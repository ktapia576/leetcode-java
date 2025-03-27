/*
HashMap store: key as value and value as index

[2,7,11,15]  target = 9

HashMap:
| 2  |  0 |
---------
| 7  |  1 |
---------
|  11 | 2 |
---------
|  15 | 3 |

9-2 = 7


// loop thru nums and store in HashMap as is

// loop thru nums and subtract current i with 9 and look for the complement

 ex: i=0
    
    target - currValue
    9 - 2 = 7

    // now lookup 7 in hashmap 
     and if value returned not equal to current ith index
     then solution found

     // if not keep going


*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[]{0,0};

        //populate map
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i); // key: value , value: index number
        }


        //find solution
        for(int i=0; i< nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement) && map.get(complement) != i) {
                arr[0] = i;
                arr[1] = map.get(complement);
                return arr; 
            }
        }

        return arr; // if not found will return [0,0]
    }
}

// Solution with ONE Pass HashMap
// O(n) time O(n) space

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {}; // if not found will return empty array
    }
}