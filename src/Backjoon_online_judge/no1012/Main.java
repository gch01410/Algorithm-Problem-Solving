package Backjoon_online_judge.no1012;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int n;
    static int k;
    static int[][] map;
    static boolean[][] visit;
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int test_case = 0; test_case < t; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visit = new boolean[m][n];

            int count = 0;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visit[nextX][nextY] && map[nextX][nextY] == 1) {
                dfs(nextX, nextY);
            }
        }
    }
}
