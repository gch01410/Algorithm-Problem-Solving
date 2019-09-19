package Backjoon_online_judge.no7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] map = new int[m + 1][n + 1][h + 1];
        int[] dirX = {0, 1, 0, -1, 0, 0};
        int[] dirY = {-1, 0, 1, 0, 0, 0};
        int[] dirZ = {0, 0, 0, 0, 1, -1};
        Queue<Integer> queue = new LinkedList<>();
        int countOfUnRipen = 0;
        int answer = -1;

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 1; k <= m; k++) {
                    map[k][j][i] = Integer.parseInt(st.nextToken());
                    if (map[k][j][i] == 1) {
                        queue.add(k);
                        queue.add(j);
                        queue.add(i);
                    } else if (map[k][j][i] == 0) {
                        countOfUnRipen++;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size() / 3;
            answer++;
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                int y = queue.poll();
                int z = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int nextX = x + dirX[j];
                    int nextY = y + dirY[j];
                    int nextZ = z + dirZ[j];
                    if (nextX >= 1 && nextX <= m && nextY >= 1 && nextY <= n && nextZ >= 1 && nextZ <= h && map[nextX][nextY][nextZ] == 0) {
                        map[nextX][nextY][nextZ] = 1;
                        countOfUnRipen--;
                        queue.add(nextX);
                        queue.add(nextY);
                        queue.add(nextZ);
                    }
                }
            }
        }

        if (countOfUnRipen != 0) {
            System.out.print(-1);
            return;
        }
        if (answer == -1) {
            System.out.print(0);
        } else {
            System.out.print(answer);
        }
    }
}
