import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++){
            long x = sc.nextLong();
            
            if(x == 0L && minHeap.isEmpty()){
                sb.append("0").append("\n");
            }
            else if(x == 0L && !minHeap.isEmpty()){
                sb.append(minHeap.poll()).append("\n");
            }
            else {
                minHeap.add(x);
            }
        }

        System.out.print(sb.toString());
    }
}
