public class Operation {
	static int[] QS(int[] A, int l, int r){
        if(l>=r){
            return A;
        }
        int m = Partition(A,l,r);
        QS(A,l,m-1);
        QS(A,m+1,r);
        return A;
    }

    static int Partition(int[] A,int l,int r){
        int i = l-1;
        for(int j = l; j <=r; j++){
            if(A[j] <= A[r]){
                int num = A[j];
                A[j] = A[i+1];
                A[i+1] = num;
                i++;
            }
        }
        return i;
    }
}
