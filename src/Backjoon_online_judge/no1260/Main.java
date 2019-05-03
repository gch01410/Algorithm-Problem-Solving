package Backjoon_online_judge.no1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static StringBuilder sb;
    static int n;
    static int m;
    static int v;
    static boolean[] dfsDp;
    static boolean[] bfsDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        dfsDp = new boolean[n + 1];
        bfsDp = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arr[num1][num2] = 1;
            arr[num2][num1] = 1;
        }
        sb = new StringBuilder();
        dfs(v);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        bfs(v);
        System.out.print(sb.toString());
    }

    private static void dfs(int v) {
        dfsDp[v] = true;
        sb.append(v).append(" ");

        for (int i = 1; i <= n; i++) {
            if (arr[v][i] == 1 && !dfsDp[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        bfsDp[v] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            for (int i = 1; i <= n; i++) {
                if (arr[now][i] == 1 && !bfsDp[i]) {
                    queue.add(i);
                    bfsDp[i] = true;
                }
            }
        }
    }
}
