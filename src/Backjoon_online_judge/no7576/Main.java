package Backjoon_online_judge.no7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[m][n];
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        int[] dirX = new int[]{0, 0, -1, 1};
        int[] dirY = new int[]{-1, 1, 0, 0};
        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                dp[j][i] = Integer.parseInt(st.nextToken());

                if (dp[j][i] == 1) {
                    queueX.add(j);
                    queueY.add(i);
                }
            }
        }

        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            for (int j = 0; j < 4; j++) {
                int nextX = x + dirX[j];
                int nextY = y + dirY[j];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && dp[nextX][nextY] == 0) {
                    dp[nextX][nextY] = dp[x][y] + 1;
                    count = dp[x][y];
                    queueX.add(nextX);
                    queueY.add(nextY);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
}
