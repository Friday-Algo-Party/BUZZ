import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){ 
            sb.append(A[i]).append('\n'); 
        }

        System.out.print(sb.toString());
    }
}
