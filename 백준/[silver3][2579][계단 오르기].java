import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner ac = new Scanner(System.in);
        int N = ac.nextInt();
        int A[] = new int[N + 1];
        int DP[][] = new int[N + 1][3];

        for(int i = 1; i <= N; i++){
            A[i] = ac.nextInt();
        }

        for(int i = 1; i <= N; i++){
            DP[i][0] = Math.max(DP[i - 1][1], DP[i - 1][2]);
            DP[i][1] = DP[i - 1][0] + A[i];
            DP[i][2] = DP[i - 1][1] + A[i];
        }

        System.out.print(Math.max(DP[N][1], DP[N][2]));
    }
}
