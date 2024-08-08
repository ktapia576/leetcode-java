public class HappyNumber {
    // *************  LEETCODE PROBLEM 202 *******************

    
    class Solution {
        public boolean isHappy(int n) {
            int slow = n;
            int fast = n;

            do {
                slow = sumOfDigits(slow);
                fast = sumOfDigits(sumOfDigits(fast));

                if(slow == 1) {return true;}
            }
            while(slow != fast);

            return false;
        }

        public int sumOfDigits(int n) {
            int sum = 0;

            // get sum of digits of current pass
            while (n > 0) {
                // Get one's place digit seperately
                int remainder = n % 10;
                int squareDigit = remainder * remainder;

                // move the number down one tenths place
                n = n / 10;

                // add squared digit to sum
                sum += squareDigit;
            }

            return sum;
        }
    }
}
