package Backjoon_online_judge.no2178;

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[m + 2][n + 2];
//        Queue<int[]> queueX = new LinkedList<>();
        Queue<Pair> queueX = new LinkedList<>();
        int[] dirX = new int[]{0, 0, -1, 1};
        int[] dirY = new int[]{-1, 1, 0, 0};

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 1; j <= m; j++) {
                map[j][i] = str.charAt(j - 1) - '0';
            }
        }

//        queueX.add(new int[]{1, 1});
        queueX.add(new Pair(1,1));

        while (!queueX.isEmpty()) {
//            int[] a = queueX.poll();
            Pair pair = queueX.poll();
            int x = pair.x;
            int y = pair.y;

            if (x == m && y == n) {
                System.out.println(map[m][n]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + dirX[i];
                int nextY = y + dirY[i];

                if (map[nextX][nextY] == 1) {
//                    queueX.add(new int[]{nextX, nextY});
                    queueX.add(new Pair(nextX,nextY));
                    map[nextX][nextY] = map[x][y] + 1;
                }
            }
        }
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
