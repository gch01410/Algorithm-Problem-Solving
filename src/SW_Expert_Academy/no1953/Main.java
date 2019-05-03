package SW_Expert_Academy.no1953;

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
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int[][] map = new int[m][n];
            boolean[][] visit = new boolean[m][n];
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            queue.add(a);
            queue.add(b);
            visit[a][b] = true;

            while (!queue.isEmpty() && time > 1) {
                int size = queue.size() / 2;
                time--;
                for (int i = 0; i < size; i++) {
                    int x = queue.poll();
                    int y = queue.poll();

//                    count++;
//                    visit[x][y] = true;
//                    System.out.println(x+" "+y);

                    if (map[x][y] == 1) {
                        if (x > 0 && !visit[x - 1][y] && (map[x - 1][y] == 1 || map[x - 1][y] == 3 || map[x - 1][y] == 4 || map[x - 1][y] == 5)) {
                            queue.add(x - 1);
                            queue.add(y);
                            visit[x - 1][y] = true;
                        }
                        if (x < m - 1 && !visit[x + 1][y] && (map[x + 1][y] == 1 || map[x + 1][y] == 3 || map[x + 1][y] == 6 || map[x + 1][y] == 7)) {
                            queue.add(x + 1);
                            queue.add(y);
                            visit[x + 1][y] = true;
                        }
                        if (y > 0 && !visit[x][y - 1] && (map[x][y - 1] == 1 || map[x][y - 1] == 2 || map[x][y - 1] == 5 || map[x][y - 1] == 6)) {
                            queue.add(x);
                            queue.add(y - 1);
                            visit[x][y - 1] = true;
                        }
                        if (y < n - 1 && !visit[x][y + 1] && (map[x][y + 1] == 1 || map[x][y + 1] == 2 || map[x][y + 1] == 4 || map[x][y + 1] == 7)) {
                            queue.add(x);
                            queue.add(y + 1);
                            visit[x][y + 1] = true;
                        }
                    } else if (map[x][y] == 2) {
                        if (y > 0 && !visit[x][y - 1] && (map[x][y - 1] == 1 || map[x][y - 1] == 2 || map[x][y - 1] == 5 || map[x][y - 1] == 6)) {
                            queue.add(x);
                            queue.add(y - 1);
                            visit[x][y - 1] = true;
                        }
                        if (y < n - 1 && !visit[x][y + 1] && (map[x][y + 1] == 1 || map[x][y + 1] == 2 || map[x][y + 1] == 4 || map[x][y + 1] == 7)) {
                            queue.add(x);
                            queue.add(y + 1);
                            visit[x][y + 1] = true;
                        }
                    } else if (map[x][y] == 3) {
                        if (x > 0 && !visit[x - 1][y] && (map[x - 1][y] == 1 || map[x - 1][y] == 3 || map[x - 1][y] == 4 || map[x - 1][y] == 5)) {
                            queue.add(x - 1);
                            queue.add(y);
                            visit[x - 1][y] = true;
                        }
                        if (x < m - 1 && !visit[x + 1][y] && (map[x + 1][y] == 1 || map[x + 1][y] == 3 || map[x + 1][y] == 6 || map[x + 1][y] == 7)) {
                            queue.add(x + 1);
                            queue.add(y);
                            visit[x + 1][y] = true;
                        }
                    } else if (map[x][y] == 4) {
                        if (x < m - 1 && !visit[x + 1][y] && (map[x + 1][y] == 1 || map[x + 1][y] == 3 || map[x + 1][y] == 6 || map[x + 1][y] == 7)) {
                            queue.add(x + 1);
                            queue.add(y);
                            visit[x + 1][y] = true;
                        }
                        if (y > 0 && !visit[x][y - 1] && (map[x][y - 1] == 1 || map[x][y - 1] == 2 || map[x][y - 1] == 5 || map[x][y - 1] == 6)) {
                            queue.add(x);
                            queue.add(y - 1);
                            visit[x][y - 1] = true;
                        }
                    } else if (map[x][y] == 5) {
                        if (x < m - 1 && !visit[x + 1][y] && (map[x + 1][y] == 1 || map[x + 1][y] == 3 || map[x + 1][y] == 6 || map[x + 1][y] == 7)) {
                            queue.add(x + 1);
                            queue.add(y);
                            visit[x + 1][y] = true;
                        }
                        if (y < n - 1 && !visit[x][y + 1] && (map[x][y + 1] == 1 || map[x][y + 1] == 2 || map[x][y + 1] == 4 || map[x][y + 1] == 7)) {
                            queue.add(x);
                            queue.add(y + 1);
                            visit[x][y + 1] = true;
                        }
                    } else if (map[x][y] == 6) {
                        if (y < n - 1 && !visit[x][y + 1] && (map[x][y + 1] == 1 || map[x][y + 1] == 2 || map[x][y + 1] == 4 || map[x][y + 1] == 7)) {
                            queue.add(x);
                            queue.add(y + 1);
                            visit[x][y + 1] = true;
                        }
                        if (x > 0 && !visit[x - 1][y] && (map[x - 1][y] == 1 || map[x - 1][y] == 3 || map[x - 1][y] == 4 || map[x - 1][y] == 5)) {
                            queue.add(x - 1);
                            queue.add(y);
                            visit[x - 1][y] = true;
                        }
                    } else if (map[x][y] == 7) {
                        if (x > 0 && !visit[x - 1][y] && (map[x - 1][y] == 1 || map[x - 1][y] == 3 || map[x - 1][y] == 4 || map[x - 1][y] == 5)) {
                            queue.add(x - 1);
                            queue.add(y);
                            visit[x - 1][y] = true;
                        }
                        if (y > 0 && !visit[x][y - 1] && (map[x][y - 1] == 1 || map[x][y - 1] == 2 || map[x][y - 1] == 5 || map[x][y - 1] == 6)) {
                            queue.add(x);
                            queue.add(y - 1);
                            visit[x][y - 1] = true;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
//                    System.out.printf("%6b", visit[j][i]);
                    if (visit[j][i]) {
                        count++;
                    }
                }
//                System.out.println();
            }

            System.out.println("#" + (t + 1) + " " + count);
        }
    }
}