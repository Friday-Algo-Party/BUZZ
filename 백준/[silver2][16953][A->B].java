import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static long target;
    public static Set<Long> visitedSet;

    public static class Node{
        long data;
        long count;

        public Node(long data, long count){
            this.data = data;
            this.count = count;
        }
    }
    
    public static long bfs(long start){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            long new1 = node.data * 2;
            long new2 = node.data * 10 + 1;

            if(target == new1 || target == new2){
                return node.count + 1;
            }

            if(new1 < target && !visitedSet.contains(new1)){
                queue.add(new Node(new1, node.count + 1));
                visitedSet.add(new1);
            }
            if(new2 < target && !visitedSet.contains(new2)){
                queue.add(new Node(new2, node.count + 1));
                visitedSet.add(new2);
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        visitedSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        target = sc.nextInt();

        System.out.println(bfs(A));
    }
}
