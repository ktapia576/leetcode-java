// n has to be equal to 1 or greater than 1. 
// If a player gets n as 1, then they lose and cant make a move

// So, its optimal to make a move that will have the other player receive an ODD number...
// because if they recieve an ODD number, they are forced to make x = 1, which will make YOUR 
// number EVEN and repeat process...

// Once the player who gets EVENs all the time, gets n=2, they subtract by 1 and the other
// player must and can ONLY choose 1 to divide it by... HOWEVER, there is the constraint 1<= n <= 1000
// which means n can only equal 1 and never be lower... so current player has NO moves, they lose.

// This is a mathematical solution to problem

class Solution {
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}