import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static long getSum(int[] trees, int size, int height) {
        long sum = 0;
        for (int i = 0; i < size; i++) {
            int temp = trees[i] - height;
            if (temp > 0) {
                sum += temp;
            }
        }
        return sum;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int start = 0;
        int end = 2_000_000_000;
        int max = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long cal = getSum(A, N, mid);
            if (cal >= M) {
                max = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(max);
    }
}
