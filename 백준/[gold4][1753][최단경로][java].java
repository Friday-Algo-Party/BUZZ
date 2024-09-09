import java.util.*;
import java.io.*;

class Main {
    private static List<List<Edge>> A;
    private static int[] distances;
    private static boolean[] visited;
    private static PriorityQueue<Edge> pq;
    private static int V;
    private static int E;
    private static int startVertex;
    
    private static class Edge {
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void addEdge(int u, int v, int weight) {
        A.get(u).add(new Edge(v, weight));
    }

    public static void dijkstra(int start) {
        distances[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.vertex;
            if (visited[u]) continue;

            visited[u] = true;

            for (Edge next : A.get(u)) {
                if (visited[next.vertex]) continue;

                int v = next.vertex;
                int weight = next.weight;
                int newDist = distances[u] + weight;
                if (newDist < distances[v]) {
                    distances[v] = newDist;
                    pq.add(new Edge(v, distances[v]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(br.readLine()) - 1;

        A = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            A.add(new ArrayList<>());
        }

        distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        visited = new boolean[V];
        pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            addEdge(u, v, w);
        }

        dijkstra(startVertex);

        for (int i = 0; i < V; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distances[i]);
            }
        }
    }
}
