public class HappyNumber {
    // *************  LEETCODE PROBLEM 202 *******************
    /*


     */

    class Solution {
        public boolean isHappy(int n) {
            int count = 0;

            while(count < 9000){
                int sum = sumOfDigits(n);

                n = sum;

                if(sum == 1){
                    return true;
                }

                count++;
            }

            return false;
        }

        public int sumOfDigits(int n){
            int sum = 0;

            // get sum of digits of current pass
            while(n > 0){
                // Get one's place digit seperately
                int remainder = n % 10;
                int squareDigit = remainder * remainder;

                // move the number down one tenths place
                n = n/10;

                // add squared digit to sum
                sum += squareDigit;
            }

            return sum;
        }
    }
}
