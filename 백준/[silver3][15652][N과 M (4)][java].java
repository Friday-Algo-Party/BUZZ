import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] result = new int[M];
        answer(N, M, result, 0, 1);
    }

    public static void answer(int N, int M, int[] result, int depth, int start) {
        if (depth == M) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            result[depth] = i;
            answer(N, M, result, depth + 1, i);
        }
    }
}
