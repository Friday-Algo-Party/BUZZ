import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int MAX = 100_000;
    
    public static int bfs(int[] A, int start, int goal){
        Deque<Integer> deque = new LinkedList<>();
        A[start] = 0;
        deque.offer(start);

        while(!deque.isEmpty()){
            int cur = deque.poll();

            if(cur == goal) return A[cur];

            int next = cur * 2;
            if(next <= MAX && A[next] > A[cur]){
                A[next] = A[cur];
                deque.addFirst(next);
            }

            next = cur - 1;
            if(next >= 0 && next <= MAX && A[next] > A[cur] + 1){
                A[next] = A[cur] + 1;
                deque.addLast(next);
            }

            next = cur + 1;
            if(next >= 0 && next <= MAX && A[next] > A[cur] + 1){
                A[next] = A[cur] + 1;
                deque.addLast(next);
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[MAX + 1];
        Arrays.fill(A, Integer.MAX_VALUE);

        System.out.println(bfs(A, N, K));
    }
}
