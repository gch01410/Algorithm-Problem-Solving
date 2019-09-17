package Backjoon_online_judge.no2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    private static int n;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dirX = {0, 1, 0, -1};
    private static int[] dirY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];
        int answer = 0;
        List<Integer> counts = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <= n; j++) {
                map[j][i] = Integer.parseInt(line.substring(j - 1, j));
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[j][i] == 1 && !visit[j][i]) {
                    int count = 0;
                    visit[j][i] = true;
                    answer++;
                    counts.add(dfs(i, j, count));
                }
            }
        }
        counts.sort(Integer::compareTo);

        System.out.println(answer);
        for (Integer count : counts) {
            System.out.println(count);
        }
    }

    private static int dfs(int i, int j, int count) {
        count++;
        for (int k = 0; k < 4; k++) {
            int nextX = j + dirX[k];
            int nextY = i + dirY[k];

            if (nextX <= n && nextX >= 1 && nextY <= n && nextY >= 1 && map[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                visit[nextX][nextY] = true;
                count = dfs(nextY, nextX, count);
            }
        }
        return count;
    }
}
