import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static int bfs(int[][] MAP, Queue<int[]> queue, int N, int M) {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int y = curr[0];
                int x = curr[1];

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && MAP[ny][nx] == 0) {
                        MAP[ny][nx] = 1; 
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return days == -1 ? 0 : days; 
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] MAP = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MAP[i][j] = sc.nextInt();
                if (MAP[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int days = bfs(MAP, queue, N, M);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j] == 0) { 
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(days);
    }
}
