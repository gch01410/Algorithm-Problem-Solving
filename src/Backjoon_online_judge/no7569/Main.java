package Backjoon_online_judge.no7569;

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
        int h = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[m][n][h];
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        Queue<Integer> queueZ = new LinkedList<>();
        int[] dirX = new int[]{0, 0, -1, 1, 0, 0};
        int[] dirY = new int[]{-1, 1, 0, 0, 0, 0};
        int[] dirZ = new int[]{0, 0, 0, 0, 1, -1};
        int count = 0;
        int ripen = 0;
        int empty = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    dp[k][j][i] = num;
                    if (num == 1) {
                        ripen++;
                        queueX.add(k);
                        queueY.add(j);
                        queueZ.add(i);
                    } else if (num == -1) {
                        empty++;
                    }
                }
            }
        }

        if (ripen+empty == m*n*h){
            System.out.println(0);
            return;
        }

        while (!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();
            int z = queueZ.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = x + dirX[i];
                int nextY = y + dirY[i];
                int nextZ = z + dirZ[i];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && nextZ >= 0 && nextZ < h && dp[nextX][nextY][nextZ] == 0) {
                    queueX.add(nextX);
                    queueY.add(nextY);
                    queueZ.add(nextZ);
                    dp[nextX][nextY][nextZ] = dp[x][y][z] + 1;
                    count = dp[x][y][z];
                    ripen++;
                }
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < h; k++) {
//                    if (dp[i][j][k] == 0) {
//                        System.out.println(-1);
//                        return;
//                    }
//                }
//            }
//        }

        if (ripen+empty == m*n*h){
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
//        System.out.println(count);
    }
}
