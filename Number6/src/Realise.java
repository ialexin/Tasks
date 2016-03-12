import java.util.Random;

public class Realise {
	
		
	public static void qSortSingleRecurison(int[] mas, int leftBorder, int rightBorder){
		while (leftBorder < rightBorder) {
            //find index placed on correct index number
            int foundPos = placeInRightPos(mas, leftBorder, rightBorder);
            //sort part placed before foundPos
            qSortSingleRecurison(mas, leftBorder, foundPos);
            //shift right leftBorder pointer for new while iteration
            leftBorder = foundPos + 1;
        }
	}
	
	
	/**
     * Places x = mas[med] (med - random number) in correct position
     * in segment [leftBorder, rightBorder] in array mas
     * (based on Hoare-partition algorithm)
     * @param mas Array
     * @param leftBorder left edge index
     * @param rightBorder right edge index
     * @return Correct index of x
     */
    public static int placeInRightPos(int[] mas, int leftBorder, int rightBorder)
    {
		Random rnd = new Random();
		int med = rnd.nextInt(rightBorder - leftBorder + 1) + leftBorder;
		int x = mas[med];
		int i = leftBorder - 1;
		int j = rightBorder + 1;
		while (true) {
            do {
                i++;
            } while (mas[i] <= x);
            do {
                j--;
            } while (x <= mas[j]);
            if (i <= j) {
                swap(mas, i, j);
            } else  if ((j - leftBorder) < (rightBorder - i)){
            	if (leftBorder < j){
            		return j;
            	}
            }
            
        }
    }
	
	
	public static void method(int[] arr, int leftBorder, int rightBorder) {
		do {
			int i = leftBorder;
			int j = rightBorder;
			int mid = arr[(i + j) / 2];
			do {
				while (arr[i] < mid)
					i++; 
				while (arr[j] > mid)
					j--;
				if (i <= j) {
					swap(arr, i, j);

					i++;
					j--;
				}
			} while (i <= j);
			if ((j - leftBorder) < (rightBorder - i)) {
				if (leftBorder < j) {

					method(arr, leftBorder, j);
				}
				leftBorder = i;
			} else {
				if (i < rightBorder) {
					method(arr, i, rightBorder);
				}
				rightBorder = j;
			}
		} while (leftBorder != rightBorder);
	}
	
	private static void swap(int[] mas, int left, int right) {
		int temp = mas[left];
		mas[left] = mas[right];
		mas[right] = temp;
	}
}
