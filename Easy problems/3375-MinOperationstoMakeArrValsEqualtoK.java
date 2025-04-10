// my first solution utilizing the assumption that nums[i] will not be greater than 100

// I used a seen array that has its super simple basic hashing function lol

// if seen make equal to 1

// if nums[i] < k then return -1 because then we cant have a valid h that will make the whole array equal to k

// then use a counter to see how many times we see a number that is not equal to k.

// this simulates having to make a valid "h" and then making another valid 'h' and going on until you reach h = k

// so you do not have to mutate array or actually preform operation. just count how many different integers until we reach k

// since that is how many times/operations it will take to make all the integers in k equal h

// this is solution can be further optimized by using a maxVal variable and starting the second for loop there instead of at 100

// but this solution is not optimal if nums[i] > 100 and grows to possibly 10^8 (100,000,000).. and each int in array is 4 bytes per int then this will be 4GB of memory!

// so its better to utilize hashset after that size and then get the size() of hashset for the "count"

class Solution {
    public int minOperations(int[] nums, int k) {
        int[] seen = new int[101];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < k) { return -1; }
            seen[nums[i]] = 1;
        }

        int count = 0;
        for(int i = 100; i >= 1; i--){
            if( i == k){ break; }
            if( seen[i] > 0){ count++; }
        }

        return count;
    }
}

// Solution with hashset that allows nums[i] to be greater than 100 if needed.

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < k) { return -1; }
            if(nums[i] > k) {
                seen.add(nums[i]);
            }
        }

        return seen.size();
    }
}