import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            String data = br.readLine();
            map1.put(data, i);
            map2.put(i, data);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String data = br.readLine();
            if('A' <= data.charAt(0) && data.charAt(0) <= 'Z'){
                sb.append(map1.get(data)).append("\n");
            }
            else {
                sb.append(map2.get(Integer.parseInt(data))).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
