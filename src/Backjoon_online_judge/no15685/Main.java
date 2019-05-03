package Backjoon_online_judge.no15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] input = new int[n][4];
        LinkedList<Integer>[] list = new LinkedList[n];
        int[][] map = new int[101][101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list[i] = new LinkedList<>();
            for (int j = 0; j < 4; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            int age = input[i][3];
            list[i].push(input[i][2]);
            int x = input[i][0];
            int y = input[i][1];
            map[x][y] = 1;
            if (input[i][2] == 0) {
                x++;
                if (x <= 100) {
                    map[x][y] = 1;
                }
            } else if (input[i][2] == 1) {
                y--;
                if (y >= 0) {
                    map[x][y] = 1;
                }
            } else if (input[i][2] == 2) {
                x--;
                if (x >= 0) {
                    map[x][y] = 1;
                }
            } else if (input[i][2] == 3) {
                y++;
                if (y <= 100) {
                    map[x][y] = 1;
                }
            }
            list[i].add(changeDir(input[i][2]));

            for (int j = 0; j < age; j++) {
                int size = list[i].size();
                int index = size / 2;
                for (int k = 0; k < size / 2; k++) {
                    int dir = list[i].get(index);
                    index++;
                    if (dir == 0) {
                        x++;
                        if (x >= 0 && x <= 100 && y >= 0 && y <= 100) {
                            map[x][y] = 1;
                        }
                    } else if (dir == 1) {
                        y--;
                        if (x >= 0 && x <= 100 && y >= 0 && y <= 100) {
                            map[x][y] = 1;
                        }
                    } else if (dir == 2) {
                        x--;
                        if (x >= 0 && x <= 100 && y >= 0 && y <= 100) {
                            map[x][y] = 1;
                        }
                    } else if (dir == 3) {
                        y++;
                        if (x >= 0 && x <= 100 && y >= 0 && y <= 100) {
                            map[x][y] = 1;
                        }
                    }
                }
                for (int k = 0; k < size; k++) {
                    list[i].add(changeDir(list[i].get(size - 1 - k)));
                }
            }
        }
        int result = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
                    result++;
                }
            }
        }
        System.out.print(result);
    }

    private static int changeDir(int dir) {
        switch (dir) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            default:
                return 0;
        }
    }
}