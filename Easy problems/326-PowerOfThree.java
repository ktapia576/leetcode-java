// now remembered that if you take, for example, log(27)/log(3) = 3 --> 3^3 = 27

// log(81)/log(3) = 4 ---> 3^4 = 81

// now how to check if that returns a decimal vs whole integer

// above solution quickly became naive due to decimal approximation in java and
// decimals not being stored exactly in binary
//------------------------------------------------------------------------------
// This solution can be solved iteratively with while loop O(n)
// which is slow but accurate
// this is by dividing n by 3 until not divisible anymore
// if the result of the dividing returns 1... that means it was a power of three
//------------------------------------------------------------------------------
// It can also be solved by taking the maximum power of three allowed to be stored in an int
// then taking modulo of any n that is greater than 0
// if the resulting modulus is 0, then that means it is a power of three

// Max int in java = 2,147,483,647
// Highest power of three = 1,162,261,467

// every power of three less than 1,162,261,467 will be divisible and leave no remainder


class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}

/* ITERATIVE SOLUTION: O(n) Time

public boolean isPowerOfThree(int n) {
    if (n <= 0) return false;
    while (n % 3 == 0) {
        n /= 3;
    }
    return n == 1;
}
/*