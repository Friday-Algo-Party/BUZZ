import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static List<List<Integer>> A;
    public static Boolean[] checked;

    public static void DFS(int start){
        if(checked[start]) return;

        checked[start] = true;
        for(int next : A.get(start)){
            if(!checked[next]) {
                DFS(next);
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList<>();
        checked = new Boolean[N + 1];
        for(int i = 0; i < N + 1; i++){
            checked[i] = false;
            A.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            A.get(node1).add(node2);
            A.get(node2).add(node1);
        }

        int count = 0;
        // System.out.print(Arrays.toString(checked));
        for(int i = 1; i < N + 1; i++){
            if(!checked[i]){
                DFS(i);
                count++;
            }
        }

        System.out.print(count);
        
    }
}

