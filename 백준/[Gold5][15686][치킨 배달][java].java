import java.util.*;
import java.io.*;

class Main {
    public static class Node{
        int y;
        int x;

        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static List<List<Integer>> combination(int[] arr, int r){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combineHelper(arr, r, 0, temp, result);
        return result;
    }

    public static void combineHelper(int[] arr, int r, int start, List<Integer> temp, List<List<Integer>> result){
        if (temp.size() == r) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            combineHelper(arr, r, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static int findLength(Node node1, Node node2){
        return Math.abs(node1.y - node2.y) + Math.abs(node1.x - node2.x);
    }

    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node> homeList = new ArrayList<>();
        List<Node> chichenList = new ArrayList<>();
        

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int data = Integer.parseInt(st.nextToken());
                if(data == 1) homeList.add(new Node(i, j));
                else if(data == 2) chichenList.add(new Node(i, j));
            }
        }

        
        int[] arr = new int[chichenList.size()];
        for(int i = 0; i < chichenList.size(); i++){
            arr[i] = i;
        }

        List<List<Integer>> chooses = combination(arr, M);
        int MIN = Integer.MAX_VALUE ;
        
        for (List<Integer> choose : chooses) {
            int temp = 0;
            for (Node homeNode : homeList) {
                int homeMin = Integer.MAX_VALUE;
                for (Integer chichenPos : choose) {
                    Node chickenNode = chichenList.get(chichenPos);
                    int distance = findLength(chickenNode, homeNode);
                    homeMin = Math.min(homeMin, distance);
                }
                temp += homeMin;
            }

            MIN = Math.min(MIN, temp);
        }
        
        System.out.println(MIN);
    }
}


/*
1초(다이나믹 삘인데 아니네..) 
N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)

N * N 도시가 잇음
치킨 거리는 집과 치킨의 거리임
도시의 치킨 거리는 모든 치킨 거리의 합
0은 빈 칸, 1은 집, 2는 치킨집

도시에 치킨집이 n개가 있다고 했을 때
치킨 거리를 구하려면 한 집당 n번 구해서 최소값을 찾아야 한다

근데 여기 문제의 핵심은 치킨집은 모두 같은 프랜차이즈라서
줄여야 M개로 줄여야 한다
그래서 도시의치 치킨거리가 최솟값이 되는 것을 구해야 한다

음....

치킨 집의 좌표는 리스트에 넣으면 좋을 듯함
그리고 집의 좌표도 리스트에 넣으면 좋을 듯하네유
치킨집에 번호를 부여해서 조합으로 뽑고
각 치킨집 마다 거리를 계산해서 최솟값을 찾아서 출력하면 될듯??



*/
