import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N + 1][N + 1];
        int[][] S = new int[N + 1][N + 1];

        // 입력
        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++){ A[i][j] = Integer.parseInt(st.nextToken()); }
        }

        //합 배열 만들기
        for(int i = 1; i < N + 1; i++){
            S[1][i] = S[1][i - 1] + A[1][i];
            S[i][1] = S[i - 1][1] + A[i][1];
        }
        
        for(int i = 2; i < N + 1; i++){
            for(int j = 2; j < N + 1; j++) {
                if (S[i][j] == 0){
                    S[i][j] = S[i][j - 1] + S[i - 1][j] - S[i - 1][j - 1] +  A[i][j];
                }
            }
        }
        //  for (int i = 1; i <= N; i++) {
        //     for (int j = 1; j <= N; j++) {
        //         System.out.print(S[i][j] + " ");  
        //     }
        //     System.out.println();  
        // }

        //입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2){
                System.out.println(A[x1][y2]);
                continue;
            }
            
            int sum = S[x2][y2] + S[x1-1][y1-1] - S[x2][y1-1] - S[x1-1][y2];
            System.out.println(sum);
        }
    }
}
