import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int func(Scanner sc){
        int n  = sc.nextInt();
        int[][] A = new int[2][n + 1];
        int[][] dp = new int [3][n + 1];

        for(int i = 0; i < 2; i++){
            for(int j = 1; j < n + 1; j++){
                A[i][j] = sc.nextInt();
            }
        }


        dp[1][1] = A[0][1];
        dp[2][1] = A[1][1];
        for(int i = 2; i < n + 1; i++){
            dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + A[0][i];
            dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]) + A[1][i];
        }


        return Math.max(dp[1][n], dp[2][n]);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            System.out.println(func(sc));
        }
    }
}
