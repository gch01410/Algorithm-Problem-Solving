package Backjoon_online_judge.no17141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] tempMap;
    static int num1;
    static int num2;
    static int result;
    static int count;
    static boolean[] selectCleaner;
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {-1, 0, 1, 0};
    static ArrayList<Cleaner> cleanerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        tempMap = new int[n][n];
        num1 = 0;
        num2 = 0;
        result = 1000000;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
                tempMap[j][i] = map[j][i];
                if (map[j][i] == 1) {
                    num1++;
                } else if (map[j][i] == 2) {
                    cleanerList.add(new Cleaner(j, i));
                    num2++;
                }
            }
        }

        selectCleaner = new boolean[cleanerList.size()];

        dfs(0, 0);

        if (result == 1000000) {
            result = -1;
        }

        System.out.print(result);
    }

    private static void dfs(int index, int num) {
        if (num == m) {
            count = -1;
            int tempNum2 = m;
            Queue<Integer> queue = new LinkedList<>();
            boolean[][] visit = new boolean[n][n];
            for (int i = 0; i < cleanerList.size(); i++) {
                if (selectCleaner[i]) {
                    queue.add(cleanerList.get(i).x);
                    queue.add(cleanerList.get(i).y);
                    visit[cleanerList.get(i).x][cleanerList.get(i).y] = true;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tempMap[j][i] = map[j][i];
                }
            }

            while (!queue.isEmpty()) {
                int size = queue.size() / 2;

                count++;

                if ((tempNum2 + num1) == n * n) {
                    break;
                }

                for (int i = 0; i < size; i++) {
                    int x = queue.poll();
                    int y = queue.poll();


                    for (int j = 0; j < 4; j++) {
                        int nextX = x + dirX[j];
                        int nextY = y + dirY[j];

                        if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visit[nextX][nextY] && tempMap[nextX][nextY] != 1) {
                            queue.add(nextX);
                            queue.add(nextY);
                            visit[nextX][nextY] = true;
                            tempMap[nextX][nextY] = 2;
                            tempNum2++;
                        }

                    }
                }
            }

            if (tempNum2 + num1 < n * n) {
                count = -1;
            }

            if (count != -1) {
                result = Math.min(result, count);
            }

            return;
        }

        if (index >= selectCleaner.length) {
            return;
        }

        selectCleaner[index] = true;
        dfs(index + 1, num + 1);
        selectCleaner[index] = false;
        dfs(index + 1, num);

    }
}

class Cleaner {
    int x;
    int y;

    Cleaner(int x, int y) {
        this.x = x;
        this.y = y;
    }
}