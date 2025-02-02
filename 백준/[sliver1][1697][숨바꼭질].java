 import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    private static int K;
    private static int[] V = new int[100001];
    
    public static int func(int start){
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> nextLevel = new LinkedList<>();
        queue.add(start);
        V[start] = 1;
        int time = 0;

        if (start == K) {
            return 0;
        }

        while (!queue.isEmpty()) {
            while(!queue.isEmpty()){
                int p = queue.poll();
            
                int p1 = p + 1;
                int p2 = p - 1;
                int p3 = p * 2;
                
                if(p1 == K || p2 == K || p3 == K){ return time + 1;}
                
                if(p1 >= 0 && p1 <= 100000 && V[p1] == 0) {nextLevel.add(p1); V[p1] = 1;}
                if(p2 >= 0 && p2 <= 100000 && V[p2] == 0) {nextLevel.add(p2); V[p2] = 1;}
                if(p3 >= 0 && p3 <= 100000 && V[p3] == 0) {nextLevel.add(p3); V[p3] = 1;}
             }

            queue = nextLevel;
            nextLevel = new LinkedList<>();
            time++;
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner ac = new Scanner(System.in);
        
        int N = ac.nextInt();
        K = ac.nextInt();
    
        System.out.print(func(N));
    }
}
/*
시간 2초
수빈이는 N점에 위치
좌우 1칸 이동하는데 1초
현재 위치에서 * 2하는데 1초

동생은 K 점에 있음

N, K 둘 다 10만 범위

5
6 4 10
7 5 12 5 3 8 11 9 20
8 6 14 6 4 10 13 11 24 6 4 10 4 2 6 9 7 16 10 9 22 10 8 18 21 19 40
19 17

방문 배열들고
들어갈 수 있는 경우의 수를 큐에 넣어서 하나씩 실행하면 될 듯요???
근데 큐는 새로 만들어서 해야 할 듯

int func(Queue queue, int time){
Queue newQueue;
 while(!queue.isEmpty()){
     int p = queue.poll();

     int p1 = p + 1;
     int p2 = p - 1;
     int p3 = p * 2;

     if(p1 == K || p2 == K || p3 == K){
         return time + 1;
     }

     newQueue.add(p1);
     newQueue.add(p2);
     newQueue.add(p3);
 }
 func(newQueue, time + 1);

 return -1;
}
*/
