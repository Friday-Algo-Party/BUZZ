/*
상근이는 나무 M 미터 필요함
목재절단기로 나무를 자를거임

목재절단기
절단기에 높이 H를 지정해야 한다
높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다
한 줄에 연속해있는 나무를 모두 절단해버린다
따라서 높이가 H보다 큰 너무는 H위의 부분이 잘린 것이고 낮은 나무는 잘리지 않을 것이다

한 줄에 연속해있는 나무의 높이가 20 15 10 17
높이 15로 지정 -> 15 15 10 15 -> 5 2 나무를 얻음

이와중에 환경에 매우 관심이 있음 그래서 필요한 만큼 집에 가져감
적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최대값을 구하는 프로그램을 작성

N: 나무의 수 (1~1백만)
M: 상근이가 집으로 가져가려는 나무의 길이 (1~20억)
시간 1초

이거 파리미틱 서치 아님?

1~2억안에 원하는 높이 찾으면 되는 것 같은데
근데 1백만번을 더해야 하는데 100번 정도만 수행할 수 있음 가능한가?
될 것 같음

A(나무 배열)
MAX(높이의 최대값)
start = 0
end = 2억 - 1

while(start < end){
int mid = (end + start) / 2;
int cal = getSum(mid);
if(cal >= M){
if(MAX < cal) MAX = cal
start = mid + 1;
}
else {
end = mid - 1;
}
}


*/

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
