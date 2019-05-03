package SW_Expert_Academy.no2382;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static int[][] map;
    private static int[] row;
    private static int[] col;
    private static int[] num;
    private static int[] dir;
    private static int size;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            map = new int[N][N];
            row = new int[K];
            col = new int[K];
            num = new int[K];
            dir = new int[K];
            size = N;
            int sum = 0;

            for (int i = 0; i < K; i++) {
                row[i] = sc.nextInt();
                col[i] = sc.nextInt();
                num[i] = sc.nextInt();
                dir[i] = sc.nextInt();
                map[row[i]][col[i]] = 1;
            }

            for (int hour = 1; hour <= M; hour++) {
                move();
            }

            for (int count : num) {
                sum += count;
            }

            System.out.printf("#%d %d\n", test_case, sum);

        }
    }

    private static void move() {
        for (int i = 0; i < row.length; i++) {
            switch (dir[i]) {
                case 1:
                    map[row[i]][col[i]]--;
                    row[i]--;
                    if (row[i] == 0) {
                        dir[i] = 2;
                        num[i] /= 2;
                    }
                    map[row[i]][col[i]]++;
                    break;

                case 2:
                    map[row[i]][col[i]]--;
                    row[i]++;
                    if (row[i] == size - 1) {
                        dir[i] = 1;
                        num[i] /= 2;
                    }
                    map[row[i]][col[i]]++;
                    break;

                case 3:
                    map[row[i]][col[i]]--;
                    col[i]--;
                    if (col[i] == 0) {
                        dir[i] = 4;
                        num[i] /= 2;
                    }
                    map[row[i]][col[i]]++;
                    break;

                case 4:
                    map[row[i]][col[i]]--;
                    col[i]++;
                    if (col[i] == size - 1) {
                        dir[i] = 3;
                        num[i] /= 2;
                    }
                    map[row[i]][col[i]]++;
                    break;
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (dir[i] != 0 && map[row[i]][col[i]] > 1) {
                int sum = num[i];
                int tempDir = dir[i];
                int tempNum = num[i];

                for (int j = i + 1; j < row.length; j++) {
                    if (row[i] == row[j] && col[i] == col[j]) {
                        sum += num[j];
                        if (tempNum < num[j]) {
                            tempNum = num[j];
                            tempDir = dir[j];
                        }
                        dir[j] = 0;
                        num[j] = 0;
                    }
                }

                map[row[i]][col[i]] = 1;
                dir[i] = tempDir;
                num[i] = sum;
            }
        }
    }
}