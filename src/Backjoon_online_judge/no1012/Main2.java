package Backjoon_online_judge.no1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    private static int t;
    private static int m;
    private static int n;
    private static int k;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dirX = {0, 1, 0, -1};
    private static int[] dirY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visit = new boolean[m][n];
            int count = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (map[l][j] == 1 && !visit[l][j]) {
                        count++;
                        dfs(l, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visit[nextX][nextY] && map[nextX][nextY] == 1) {
                visit[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }
}
