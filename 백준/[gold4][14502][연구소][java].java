import java.util.*;
import java.io.*;

class Main {
    private static int N;
    private static int M;
    private static int A[][];
    private static int tempA[][];
    private static List<Node> virusList;
    private static int[] MOVE_X = { -1, 1, 0, 0 };
    private static int[] MOVE_Y = { 0, 0, -1, 1 };
    private static int result;

    private static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void DFS(int count) {
        if (count == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                    DFS(count + 1);
                    A[i][j] = 0;
                }
            }
        }
    }

    private static void BFS() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(A[i], 0, tempA[i], 0, M);
        }

        Queue<Node> queue = new LinkedList<>();
        for (Node node : virusList) {
            queue.offer(node);
        }

        while (!queue.isEmpty()) { 
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int posX = MOVE_X[i] + node.x;
                int posY = MOVE_Y[i] + node.y;

                if (0 <= posX && posX < N && 0 <= posY && posY < M) {
                    if (tempA[posX][posY] == 0) { 
                        tempA[posX][posY] = 2;
                        queue.offer(new Node(posX, posY));
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempA[i][j] == 0) {
                    count++;
                }
            }
        }

        result = Math.max(result, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        tempA = new int[N][M];
        virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 2) {
                    virusList.add(new Node(i, j));
                }
            }
        }

        DFS(0);
        System.out.println(result);
    }
}
