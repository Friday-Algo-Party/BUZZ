import java.util.*;
import java.io.*;

class Main {
    public static int[][] A;
    public static int N;
    
    public static int DFS(int y){
        if(y == N) return 1;

        int count = 0;
        for(int i = 0; i < N; i++){
            if(isSafe(y, i)){
                A[y][i] = 1;
                count += DFS(y + 1);
                A[y][i] = 0;
            }
        }

        return count;
    }

    public static boolean isSafe(int y, int x){
        for(int i = 0; i < y; i++){
            if(A[i][x] == 1) return false;
        }

        for(int i = y - 1, j = x - 1; i >= 0 && j >= 0;  i--, j--){
            if(A[i][j] == 1) return false;
        }

        for(int i = y - 1, j = x + 1; i >= 0 && j < N;  i--, j++){
            if(A[i][j] == 1) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N][N];

        System.out.println(DFS(0));
    }
}
