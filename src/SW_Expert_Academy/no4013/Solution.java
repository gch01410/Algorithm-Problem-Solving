package SW_Expert_Academy.no4013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int test_case = 0; test_case < t; test_case++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[5][8];
            int[][] info = new int[k][2];

            for (int i = 1; i <= 4; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                info[i][0] = Integer.parseInt(st.nextToken());
                info[i][1] = Integer.parseInt(st.nextToken());
            }


            for (int i = 0; i < k; i++) {
                int num = info[i][0];
                int dir = info[i][1];
                progress(num, dir);
            }

            int score = 0;
            for (int i = 1; i <= 4; i++) {
                if (arr[i][0] == 1) {
                    score += Math.pow(2, i - 1);
                }
            }

            System.out.printf("#%d %d\n", test_case + 1, score);
        }
    }

    private static void rotate(int num, int dir) {
        if (dir == 1) {
            int temp = arr[num][7];
            for (int i = 7; i > 0; i--) {
                arr[num][i] = arr[num][i - 1];
            }
            arr[num][0] = temp;
        } else {
            int temp = arr[num][0];
            for (int i = 0; i < 7; i++) {
                arr[num][i] = arr[num][i + 1];
            }
            arr[num][7] = temp;
        }
    }

    private static boolean isRotate(int num1, int num2) {
            return arr[num1][2] != arr[num2][6];
    }

    private static void progress(int num, int dir) {
        boolean[] isConnection = {isRotate(1,2),isRotate(2,3),isRotate(3,4)};
        switch (num) {
            case 1:
                rotate(1, dir);
                if (isConnection[0]) {
                    rotate(2, -dir);
                    if (isConnection[1]) {
                        rotate(3, dir);
                        if (isConnection[2]) {
                            rotate(4, -dir);
                        }
                    }
                }
                break;
            case 2:
                rotate(2, dir);
                if (isConnection[0]) {
                    rotate(1, -dir);
                }
                if (isConnection[1]) {
                    rotate(3, -dir);
                    if (isConnection[2]) {
                        rotate(4, dir);
                    }
                }
                break;
            case 3:
                rotate(3, dir);
                if (isConnection[1]) {
                    rotate(2, -dir);
                    if (isConnection[0]) {
                        rotate(1, dir);
                    }
                }
                if (isConnection[2]) {
                    rotate(4, -dir);
                }
                break;
            case 4:
                rotate(4, dir);
                if (isConnection[2]) {
                    rotate(3, -dir);
                    if (isConnection[1]) {
                        rotate(2, dir);
                        if (isConnection[0]) {
                            rotate(1, -dir);
                        }
                    }
                }
                break;
        }
    }
}