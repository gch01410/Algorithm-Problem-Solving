package Backjoon_online_judge.no1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int[][] visit;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        visit = new int[n + 1][n + 1];
        dp = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(1, 1));
    }

    private static long dfs(int x, int y) {
        if (x == n && y == n) {
            return 1;
        }
        if (visit[x][y] == 1) {
            return dp[x][y];
        }

        visit[x][y] = 1;

        if (map[x][y] == 0) {
            return 0;
        }

        int nextX = x + map[x][y];
        int nextY = y + map[x][y];

        if (nextX <= n) {
            dp[x][y] += dfs(nextX, y);
        }
        if (nextY <= n) {
            dp[x][y] += dfs(x, nextY);
        }

        return dp[x][y];
    }
}
