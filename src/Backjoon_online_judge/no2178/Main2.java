package Backjoon_online_judge.no2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[m + 1][n + 1];
        boolean[][] visit = new boolean[m + 1][n + 1];
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <= m; j++) {
                map[j][i] = line.charAt(j - 1) - '0';
            }
        }

        queue.add(1);
        queue.add(1);
        visit[1][1] = true;

        while (!queue.isEmpty()) {
            answer++;
            int size = queue.size() / 2;
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                int y = queue.poll();

                if (x == m && y == n) {
                    System.out.print(answer);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nextX = x + dirX[j];
                    int nextY = y + dirY[j];
                    if (nextX >= 1 && nextX <= m && nextY >= 1 && nextY <= n && map[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                        queue.add(nextX);
                        queue.add(nextY);
                        visit[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
