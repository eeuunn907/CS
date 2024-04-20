import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class BFS {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static int n, m, r;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int count;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        visited[r] = 1;
        while (!q.isEmpty()) {
            int v = q.poll();
            Collections.sort(graph.get(v));
            for (int g : graph.get(v)) {
                if (visited[g] == 0) {
                    count++;
                    visited[g] = count;
                    q.add(g);
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        n = reader.nextInt();
        m = reader.nextInt();
        r = reader.nextInt();
        graph = new ArrayList<>();
        visited = new int[n + 1];
        count = 1;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs();

        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }
}