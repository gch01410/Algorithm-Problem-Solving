package Backjoon_online_judge.no17069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        dp = new long[n + 1][n + 1][4];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(dfs(2, 1, 1));

    }

    private static long dfs(int x, int y, int type) {
        if (x == n && y == n) {
            return 1;
        }
        if (dp[x][y][type] != 0) {
            return dp[x][y][type];
        }

        if (type == 1) {
            if (x + 1 <= n && map[x + 1][y] == 0) {
                dp[x][y][type] += dfs(x + 1, y, 1);
            }
            if (x + 1 <= n && y + 1 <= n && map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
                dp[x][y][type] += dfs(x + 1, y + 1, 3);
            }
        } else if (type == 2) {
            if (y + 1 <= n && map[x][y + 1] == 0) {
                dp[x][y][type] += dfs(x, y + 1, 2);
            }
            if (x + 1 <= n && y + 1 <= n && map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
                dp[x][y][type] += dfs(x + 1, y + 1, 3);
            }
        } else if (type == 3) {
            if (x + 1 <= n && map[x + 1][y] == 0) {
                dp[x][y][type] += dfs(x + 1, y, 1);
            }
            if (y + 1 <= n && map[x][y + 1] == 0) {
                dp[x][y][type] += dfs(x, y + 1, 2);
            }
            if (x + 1 <= n && y + 1 <= n && map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
                dp[x][y][type] += dfs(x + 1, y + 1, 3);
            }
        }

        return dp[x][y][type];
    }
}
