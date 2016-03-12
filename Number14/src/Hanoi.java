import java.util.Stack;

public class Hanoi {

	static StringBuilder rebuild(int n) {
		StringBuilder sB = new StringBuilder("");
		for (long k = 1; k < (1 << n); k++) {

			long h1 = ((k & (k - 1)) % 3) + 1;
			long h2 = ((k | (k - 1)) + 1) % 3 + 1;

			if (n % 2 == 0) {
				if (h1 == 2) {
					h1 = 3;
				} else if (h1 == 3) {
					h1 = 2;
				}
				if (h2 == 2) {
					h2 = 3;
				} else if (h2 == 3) {
					h2 = 2;
				}
			}
			sB.append("from ").append(h1).append(" to ").append(h2).append("\n");
		}
		return sB;
	}

    /*
     *Recursive method of solving Hanoi problem 
     */
    static Stack<Integer> RecHanoi(int N){
    Stack<Integer> A = FillStack(N);
    Stack<Integer> B = new Stack<Integer>();
    Stack<Integer> C = new Stack<Integer>();
    Stack<Integer> R = new Stack<Integer>();
    if(N != 0){
        Transposition(N, A, B, C, R);
    }
    return R;
}

static void Transposition(int N, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C, Stack<Integer> R){
    if(N == 1){
        C.push(A.pop());
        R.push(C.peek());
    }
    else{
        Transposition(N-1, A, C, B, R);
        C.push(A.pop());
        R.push(C.peek());
        Transposition(N-1, B, A, C, R);
    }
}
    
    static Stack<Integer> FillStack(int N){
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = N; i > 0 ; i--){
            stack.push(i);
        }
        return stack;
    }
    
    static Stack hanoi(int N){
        int[] positions = new int[N+1];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < N + 1; i++){
            positions[i] = 0;
        }
        int a;
        if (N % 2 == 0)
        	a = 1;
        else a = 0;

        for(int i = 1; i < (int)Math.pow(2,N); i++) {
            int ring = NumOfRing(i, 1 << N);
            int nextPosition = (positions[ring] + 3 + (int) Math.pow(-1, ring + a)) % 3;
            positions[ring] = nextPosition;
            st.push(ring);
        }
        return st;
    }

    static int NumOfRing(int spot, int N){
        int a =  (N - 1)^spot ;
        a = (a + 1) & spot;
        a = ((int) (Math.log10(a) / Math.log10(2)) + 1);
        return a;
    }
  
    
}
