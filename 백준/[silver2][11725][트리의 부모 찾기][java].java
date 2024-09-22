import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int N;
    public static List<List<Integer>> A;
    public static boolean[] visited;
    public static int[] result;
    
    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            for(Integer next : A.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    result[next] = node;
                    queue.add(next);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList<>();
        visited = new boolean[N + 1]; 
        result = new int[N + 1];
        

        for(int i = 0; i < N + 1; i++){
            A.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            A.get(node1).add(node2);
            A.get(node2).add(node1);
        }

        BFS(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < N + 1; i++){
            sb.append(result[i]).append('\n'); 
        }
        System.out.println(sb.toString());
    }
}
