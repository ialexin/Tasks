import java.util.ArrayList;

public class Realise {
	
	public int orderStat(ArrayList<Integer> a, int leftBorder, int rightBorder, int pos){
	int x = a.get(pos);
    int i = leftBorder;
    int j = rightBorder;

    while (i <= j){
        while (a.get(i) < x) 
        	i++;
        while (a.get(j) > x) 
        	j--;

        if (i <= j){
            swap(a, i, j);
            i++;
            j--;
        }
    }

    if ((leftBorder <= pos) && (pos <= j)){
        return orderStat(a, leftBorder, j, pos);
    }

    if ((pos <= rightBorder) && (pos >= i)){
        return orderStat(a, i, rightBorder, pos);
    }

    return a.get(pos);
	}
	
	/**
	 * the suffix choice for number
	 * @param k - number
	 * @return - suffix: 'st', 'nd', 'rd' or 'th'
	 */
	public String ending(int k){
		switch(k){
		case 1: return "st";
		case 2: return "nd";
		case 3: return "rd";
		default: return "th";
		}
	}
	
	/**
	 * swap 'i'th and 'j'th elements 
	 * @param arr LinkedList with dat
	 * @param i 1st index to swap
	 * @param j 2nd index to swap
	 */
	private static void swap (ArrayList<Integer> arr, int i, int j){
		int t = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, t);
	}	
}

