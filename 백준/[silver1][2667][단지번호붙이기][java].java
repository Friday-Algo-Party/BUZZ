import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    private static int N;
    private static int A[][];
    private static int MOVEX[] = {-1, 1, 0, 0};
    private static int MOVEY[] = {0, 0, -1, 1};
    private static List<Integer> result;

    private static class Node{
        public int x;
        public int y;

        public Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }

    private static int BFS(int y, int x){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x));
        A[y][x] = 0;
        int count = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int posX = MOVEX[i] + node.x;
                int posY = MOVEY[i] + node.y;

                if(0 <= posX && posX < N && 0 <= posY && posY < N && A[posY][posX] == 1){
                    A[posY][posX] = 0;
                    queue.offer(new Node(posY, posX));
                    count++;
                }
            }
        }

        return count;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        result = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                A[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(A[i][j] == 1){
                    result.add(BFS(i, j));
                }
            }
        }
        Collections.sort(result); 
        System.out.println(result.size()); 
        for (int count : result) {
            System.out.println(count); 
        }
    }
}

/*
이동하는 BFS 문제임
방문 배열은 필요없어요임 -> 0으로 변경하면 되고
주변으로 이동할 때 마다 깊이를 증가시키고 아무도 갈 때 없으면 리스트에 추가

시작 노드를 0이 아닌 곳을 찾고시작 -> BFS

for(0~N){
for(0~N){
if(y, x != 0)
 BFS(y, x);
 list.add(count);
}
}
*/
