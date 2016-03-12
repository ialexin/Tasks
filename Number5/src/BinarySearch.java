
public class BinarySearch {
	 /**
     * dichotomy
     * @param x Number, which we should guess
     * @param leftBorder Left border of guessing
     * @param rightBorder Right border of guessing
     * @return Number of flicks, gained by guessing
     */
   public int dichotomy(int x, int leftBorder, int rightBorder){
    	int flicks = 0;
    	int delta = rightBorder - leftBorder;
    	int guess = leftBorder + delta / 2;
    	
    	while (guess != x){
    		if (guess < x){
    			flicks ++;
    			leftBorder = guess;
    			delta = rightBorder - leftBorder;
    			guess = leftBorder + delta / 2;
    			if(delta < 2){
    				guess = rightBorder;
    			}
    		}
    		else {
    			flicks += 2;
    			rightBorder = guess;
    			delta = rightBorder - leftBorder;
    			guess = leftBorder + delta / 2;
    			if(delta < 2){
    				guess = leftBorder;
    			}
    		}
    	}
        return flicks;
    }
  }