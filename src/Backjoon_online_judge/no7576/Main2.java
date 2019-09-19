package Backjoon_online_judge.no7576;

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
        int[][] map = new int[m + 1][n + 1];
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};
        int countOfUnRipen = 0;
        int answer = -1;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
                if (map[j][i] == 1) {
                    queue.add(j);
                    queue.add(i);
                } else if (map[j][i] == 0) {
                    countOfUnRipen++;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size() / 2;
            answer++;

            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                int y = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = x + dirX[j];
                    int nextY = y + dirY[j];
                    if (nextX >= 1 && nextX <= m && nextY >= 1 && nextY <= n && map[nextX][nextY] == 0) {
                        map[nextX][nextY] = 1;
                        countOfUnRipen--;
                        queue.add(nextX);
                        queue.add(nextY);
                    }
                }
            }

        }
        if (answer == -1) {
            System.out.print(0);
            return;
        }

        if (countOfUnRipen == 0) {
            System.out.print(answer);
        } else {
            System.out.print(-1);
        }
    }
}
