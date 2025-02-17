import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        long[][] A = new long[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(A[i], Long.MAX_VALUE);
            A[i][i] = 0; 
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());

            A[start][end] = Math.min(A[start][end], value);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][k] != Long.MAX_VALUE && A[k][j] != Long.MAX_VALUE) {
                        A[i][j] = Math.min(A[i][j], A[i][k] + A[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(A[i][j] == Long.MAX_VALUE ? 0 : A[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
