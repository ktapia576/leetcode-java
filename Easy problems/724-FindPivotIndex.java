// so dont INCLUDE Pivot index

// naive way, two pointer appraoch?

// no better way might be to create prefix array and then scan through that?


// [1,7,3,6,5,6] output =3

// prefixArr = [0,1,8,11,17,22,28]

// left array [1,7,3] == 11
// right array [5,6] == 11 

// 28-11= 17

/*

[2,1,-1] output = 0

prefixArray = [0,2,3,2]


maybe find prefix sum array

then work right to left.. if right subarray end sum == left subarray end sum

then look one index down, if the sums equal then pivot index is current index used to calculate right subarray


// calculate prefix sum

// iterate from right to left
    // start at i th pivot index which base case nums.length-1, right subarray total = 0
    // now check is lefttotalsubarray == to righttotal
        // yes, return i - 1
        // no, keep going

    // return -1 if none found
*/

class Solution {
    public int pivotIndex(int[] nums) {
        int[] arr = new int[nums.length+1];

        // calculate prefix sum
        for(int i = 0; i < nums.length; i++){
            arr[i+1] = arr[i] + nums[i];
        }

        // iterate using ith pivot index
        int rightTotal = 0; // start at base case 0 since we start at END with empty right subarray
        if(rightTotal == arr[])
        for(int j = arr.length-1; j--){
            
        }
    }
}

// Starting from left to right since finding leftmost pivot index
// Using math to calculate what the left array total equals and th right array total equals
// then just comparing whether both sums on both sides equals the same. (not including pivot index, nums[i])

/*
[1,7,3,6,5,6] output =3

at i=2, leftSum = 8, totalSum = 28, nums[i] = 3

so we check: 8 == 28 - 8 - 3

which visualy looks like:

does [1,7] == [6,5,6] ? mathmatecially, NO (8==17 NOT TRUE)

NOTE: Pivot index element was NOT included either with calculation
------------------------------------------------

at i=3, leftSum=11, totalSum=28, nums[i] = 6

so we check: 11 == 28-11-6

which visually looks like:

does [1,7,3] == [5,6] ? YES  (11==11 TRUE)

*/

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }
        
        int leftSum = 0;
        for(int i=0; i < nums.length; i++){
            if(leftSum == totalSum - leftSum - nums[i]) { return i; }
            leftSum += nums[i];
        }

        return -1;
    }
}