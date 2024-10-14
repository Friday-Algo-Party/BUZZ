import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        int count = 0;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int curEnd = 0;
        for(int i = 0; i < N; i++){
            if(A[i][0] >= curEnd){
                curEnd = A[i][1];
                count++;
            }
        }

        System.out.print(count);
    }
}

/*
시간 2초
입력은 최대 10만
O(nlogn) 정도 안에 끝내야 함

회의대 최대 개수를 구해야 하는 문제
*/
