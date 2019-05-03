package Backjoon_online_judge.no16234;

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
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int[][] tempMap = new int[n][n];
        boolean[][] visit;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> guild = new LinkedList<>();
        int sum = 0;
        int count = -1;
        int result = 0;
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
                tempMap[j][i] = map[j][i];
            }
        }


        while (count != 0) {
            count = 0;
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sum = 0;

                    if (!visit[i][j]) {
                        queue.add(i);
                        queue.add(j);
                        guild.add(i);
                        guild.add(j);
                        sum += map[i][j];
                        visit[i][j] = true;
                    } else {
                        continue;
                    }

                    while (!queue.isEmpty()) {

                        int x = queue.poll();
                        int y = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nextX = x + dirX[k];
                            int nextY = y + dirY[k];

                            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visit[nextX][nextY] && Math.abs(map[x][y] - map[nextX][nextY]) >= l && Math.abs(map[x][y] - map[nextX][nextY]) <= r) {
                                queue.add(nextX);
                                queue.add(nextY);
                                guild.add(nextX);
                                guild.add(nextY);
                                sum += map[nextX][nextY];
                                visit[nextX][nextY] = true;
                            }
                        }
                    }

                    int size = guild.size() / 2;
                    if (size > 1) {
                        count++;
                        int value = sum / size;
                        for (int k = 0; k < size; k++) {
                            int x = guild.poll();
                            int y = guild.poll();
                            tempMap[x][y] = value;
                        }
                    } else {
                        guild.clear();
                    }

                }
            }

            if (count == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = tempMap[i][j];
                }
            }

            result++;
        }
        System.out.print(result);
    }
}
