import java.util.*;
import java.io.*;

class Main {
    public static int[] MOVE_X = {0, 0, 1, -1}; 
    public static int[] MOVE_Y = {1, -1, 0, 0};
    public static int N;
    public static int M;
    public static int[][] A;

    public static class Node {
        public int x;
        public int y;
        public int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static boolean isSafe(int y, int x) {
        return (0 <= y && y < N && 0 <= x && x < M);
    }

    public static int BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        A[0][0] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) { 
                int posX = node.x + MOVE_X[i];
                int posY = node.y + MOVE_Y[i];

                if (posY == N - 1 && posX == M - 1) return node.z + 1;
                if (isSafe(posY, posX) && A[posY][posX] == 1) {
                    queue.add(new Node(posX, posY, node.z + 1));
                    A[posY][posX] = 0;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(BFS());
    }
}
