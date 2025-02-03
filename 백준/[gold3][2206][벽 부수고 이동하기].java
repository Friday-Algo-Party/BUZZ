import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Node {
    int y, x, dist, wallBroken;
    Node(int y, int x, int dist, int wallBroken) {
        this.y = y;
        this.x = x;
        this.dist = dist;
        this.wallBroken = wallBroken;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    
    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.y == N - 1 && node.x == M - 1) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (map[ny][nx] == 0 && visited[ny][nx][node.wallBroken] == 0) {
                        if (visited[ny][nx][0] == 1) continue; 
                        visited[ny][nx][node.wallBroken] = 1;
                        queue.add(new Node(ny, nx, node.dist + 1, node.wallBroken));
                    }
                    else if (map[ny][nx] == 1 && node.wallBroken == 0 && visited[ny][nx][1] == 0) {
                        visited[ny][nx][1] = 1;
                        queue.add(new Node(ny, nx, node.dist + 1, 1));
                    }
                }
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}
