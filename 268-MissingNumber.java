/*Found pattern for "missing number"

Below is a pattern I found where left side is the length of the given array, where n == nums.length.
Right side is the "total" of what ALL the integers inside the array should equal for that "length" and range of numbers.
When there is a given range of numbers and all are distinct, it has to "total" a specific number. Which I added on the right side.

length of array -> total
-----------------------------
1->1
2->3
3->6
4->10
5->15
6->21
7->28

*NOTE: which is essentially just adding all previous numbers, but also now including the NEXT number which would be added in the next length of array.
for example: 6 totaled to 21, now for length 7, just add 7 to it.

Found a formula that calculates what the total should equal with just the given array length.
(n * (n + 1)) / 2

This is called Triangular Number Formula

After adding the total of all numbers in given array, just subtract the traingular number it should "total" to... and thats the missing number
*/

class Solution {
    public int missingNumber(int[] nums) {
        int total = 0;

        for(int i = 0; i < nums.length; i++){
            total +=nums[i];
        }

        int triangularNumber = getTriangularNumber(nums.length);
        
        return triangularNumber - total;
    }

    public static int getTriangularNumber(int n) {
        return (n * (n + 1)) / 2;
    }
}