package Backjoon_online_judge.no1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static String dfsAnswer = "";
    private static String bfsAnswer = "";
    private static boolean[] visitDfs;
    private static boolean[] visitBfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visitDfs = new boolean[n + 1];
        visitBfs = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arr[num1][num2] = 1;
            arr[num2][num1] = 1;
        }

        visitDfs[v] = true;
        dfsAnswer += v;
        dfs(v);
        System.out.println(dfsAnswer);

        bfs(v);
        System.out.println(bfsAnswer);
    }

    private static void dfs(int v) {
        for (int i = 1; i <= n; i++) {
            if (arr[v][i] == 1 && !visitDfs[i]) {
                visitDfs[i] = true;
                dfsAnswer += " " + i;
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visitBfs[v] = true;
        bfsAnswer += v;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[vertex][i] == 1 && !visitBfs[i]) {
                    queue.add(i);
                    visitBfs[i] = true;
                    bfsAnswer += " " + i;
                }
            }
        }
    }
}
