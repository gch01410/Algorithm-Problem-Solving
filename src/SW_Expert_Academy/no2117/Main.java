package SW_Expert_Academy.no2117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());
        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            int[] k = new int[2 * n];
            int[] dirX = {0, 1, 0, -1};
            int[] dirY = {-1, 0, 1, 0};
            boolean[][] visit;
            int result = 0;
            int count;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i < 2 * n; i++) {
                k[i] = i * i + (i - 1) * (i - 1);
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    queue.clear();
                    queue.add(i);
                    queue.add(j);
                    count = 0;
                    int l = 0;
                    visit = new boolean[n][n];

                    while (!queue.isEmpty() && l < 2 * n) {
                        int size = queue.size() / 2;
                        l++;

                        for (int s = 0; s < size; s++) {
                            int x = queue.poll();
                            int y = queue.poll();
                            visit[x][y] = true;

                            if (map[x][y] == 1) {
                                count++;
                            }

                            for (int p = 0; p < 4; p++) {
                                int nextX = x + dirX[p];
                                int nextY = y + dirY[p];

                                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visit[nextX][nextY]) {
                                    queue.add(nextX);
                                    queue.add(nextY);
                                    visit[nextX][nextY] = true;
                                }
                            }
                        }

                        if (count * m >= k[l]) {
                            result = Math.max(result, count);
                        }
                    }
                }
            }

            System.out.println("#" + (t + 1) + " " + result);
        }
    }
}
