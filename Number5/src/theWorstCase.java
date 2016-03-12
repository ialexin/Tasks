
public class theWorstCase {
	static int[] f = {1, 2, 4, 7, 12, 20, 33, 54, 88, 143};
	
	public static int findX(int x){
        return theWorst(1, 100, x, 9);
    }

    /**
     * How much flicks we gain by searching 'x' in range leftBorder..rightBorder
     * @param leftBorder Minimal element in range
     * @param rightBorder Maximal element in range
     * @param x Number, which we should guess
     * @param flicksAllowed Maximal amount of flicks, we want to get
     * @return Number of gained flicks
     */
    private static int theWorst(int leftBorder, int rightBorder, int x, int flicksAllowed){
        int delta = rightBorder - leftBorder;
        
        //comparing of delta value for check if algorithm is correct
        if ((flicksAllowed == 1) && (delta == 1)) {
            if (leftBorder == x) {
                return 0;
            } else if (rightBorder == x) {
                return 1;
            }
        } else if ((flicksAllowed == 0) && (leftBorder == x) && (delta == 0)) {
            return 0;
        }
        if (delta < f[flicksAllowed - 2]) {
            flicksAllowed--;
        }
        int guess = leftBorder + f[flicksAllowed - 2];
        if (guess == x) {
            return 0;
        } else if (guess < x) {
            return 1 + theWorst(guess + 1, rightBorder, x, flicksAllowed - 1);
        } else {
            return 2 + theWorst(leftBorder, guess - 1, x, flicksAllowed - 2);
        }
    }

}
