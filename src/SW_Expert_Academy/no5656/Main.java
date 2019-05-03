package SW_Expert_Academy.no5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int w;
    static int h;
    static int[][] map;
    static int min = 200;
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());
        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[w][h];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0);


            System.out.println(min);
        }
    }

    private static void dfs(int num) {
        if (num == n) {
            int count = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] > 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
            min = Math.min(min, count);

            return;
        }

        int[][] temp = new int[w][h];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, temp[i], 0, temp[i].length);
        }

//        int bombHeight = 0;
//        for (int i = 0; i < h; i++) {
//            if (map[pos][i] != 0) {
//                bombHeight = i;
//                break;
//            }
//        }
        for (int d = 0; d < w; d++) {
            for (int f = 0; f < h; f++) {
                if (map[d][f] == 1) {
                    map[d][f] = 0;
                    continue;
                }
                if (map[d][f] == 0) {
                    continue;
                }

                boolean[][] visit = new boolean[w][h];
                int bombHeight = f;

                Queue<Integer> queue = new LinkedList<>();
                queue.add(d);
                queue.add(bombHeight);
                visit[d][bombHeight] = true;

                while (!queue.isEmpty()) {
                    int x = queue.poll();
                    int y = queue.poll();
                    int power = map[x][y];
                    map[x][y] = 0;

                    for (int i = 1; i < power; i++) {
                        for (int j = 0; j < 4; j++) {
                            int nextX = x + dirX[j] * i;
                            int nextY = x + dirY[j] * i;
                            if (nextX >= 0 && nextX < w && nextY >= 0 && nextY < h && map[nextX][nextY] > 0 && !visit[nextX][nextY]) {
                                if (map[nextX][nextY] == 1) {
                                    map[nextX][nextY] = 0;
                                    continue;
                                }
                                queue.add(nextX);
                                queue.add(nextY);
                                map[nextX][nextY] = 0;
                                visit[nextX][nextY] = true;
                            }
                        }
                    }
                }


                for (int i = 0; i < w; i++) {
                    int index = h - 1;
                    for (int j = h - 1; j >= 0; j--) {
                        if (map[i][j] != 0) {
                            map[i][index] = map[i][j];
                            map[i][j] = 0;
                            index--;
                        }
                    }
                }
            }
        }

        dfs(num + 1);

    }
}
