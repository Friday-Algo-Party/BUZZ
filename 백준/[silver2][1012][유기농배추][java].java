import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] MOVEX = {0, 0, 1, -1};
    static int[] MOVEY = {1, -1, 0, 0};
    static class Node{
        public int y;
        public int x;

        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static class Answer{
        public int M;
        public int N;
        public int[][] A;
        
        public Answer(int M, int N){
            this.M = M;
            this.N = N;
            this.A = new int[N][M];
        }

        public void BFS(int y, int x){
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(y, x));
            A[y][x] = 0;

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                for(int i = 0; i < 4; i++){
                    int posY = node.y + MOVEY[i];
                    int posX = node.x + MOVEX[i];

                    if(0 <= posY && posY < N && 0 <= posX && posX < M && A[posY][posX] != 0){
                        A[posY][posX] = 0;
                         queue.add(new Node(posY, posX));
                    }
                }
            }
        }

        public int ShowResult(){
            int result = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(A[i][j] == 1){
                        BFS(i, j);
                        result++;
                    }
                }
            }

            return result;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Answer answer = new Answer(M, N);
            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                
                answer.A[Y][X] = 1;
            }
            System.out.println(answer.ShowResult());
        }
        
    }
}
