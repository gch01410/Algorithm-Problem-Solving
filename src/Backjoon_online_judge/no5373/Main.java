package Backjoon_online_judge.no5373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][][] cube;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int test_case = 0; test_case < t; test_case++) {
            cube = new char[6][3][3];
            initCube();
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                String str = st.nextToken();
                rotate(str.charAt(0), str.charAt(1));
            }
            print();
        }
    }

    private static void print() {
//        for (int k = 0; k < 6; k++) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[0][j][i]);
            }
            System.out.println();
        }
//            System.out.println();
//        }
    }

    private static void rotate(char pos, char dir) {
        switch (pos) {
            case 'L':
                left(dir);
                break;
            case 'R':
                right(dir);
                break;
            case 'U':
                up(dir);
                break;
            case 'D':
                down(dir);
                break;
            case 'F':
                front(dir);
                break;
            case 'B':
                back(dir);
                break;
        }
    }

    private static void left(char ch) {
        if (ch == '+') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[0][0][i];
                cube[0][0][i] = cube[2][0][i];
                cube[2][0][i] = cube[1][0][i];
                cube[1][0][i] = cube[3][0][i];
                cube[3][0][i] = temp;
                clockWise(4);
            }
        } else if (ch == '-') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[0][0][i];
                cube[0][0][i] = cube[3][0][i];
                cube[3][0][i] = cube[1][0][i];
                cube[1][0][i] = cube[2][0][i];
                cube[2][0][i] = temp;
                counterClockWise(4);
            }
        }
    }

    private static void right(char ch) {
        if (ch == '+') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[0][2][i];
                cube[0][2][i] = cube[3][2][i];
                cube[3][2][i] = cube[1][2][i];
                cube[1][2][i] = cube[2][2][i];
                cube[2][2][i] = temp;
                clockWise(5);
            }
        } else if (ch == '-') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[0][2][i];
                cube[0][2][i] = cube[2][2][i];
                cube[2][2][i] = cube[1][2][i];
                cube[1][2][i] = cube[3][2][i];
                cube[3][2][i] = temp;
                counterClockWise(5);
            }
        }
    }

    private static void front(char ch) {
        if (ch == '+') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[0][i][2];
                cube[0][i][2] = cube[4][i][2];
                cube[4][i][2] = cube[1][i][2];
                cube[1][i][2] = cube[5][i][2];
                cube[5][i][2] = temp;
                clockWise(3);
            }
        } else if (ch == '-') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[0][i][2];
                cube[0][i][2] = cube[5][i][2];
                cube[5][i][2] = cube[1][i][2];
                cube[1][i][2] = cube[4][i][2];
                cube[4][i][2] = temp;
                counterClockWise(3);
            }
        }
    }

    private static void back(char ch) {
        if (ch == '+') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[0][i][0];
                cube[0][i][0] = cube[5][i][0];
                cube[5][i][0] = cube[1][i][0];
                cube[1][i][0] = cube[4][i][0];
                cube[4][i][0] = temp;
//                clockWise(2);
                clockWiseBack();
            }
        } else if (ch == '-') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[0][i][0];
                cube[0][i][0] = cube[4][i][0];
                cube[4][i][0] = cube[1][i][0];
                cube[1][i][0] = cube[5][i][0];
                cube[5][i][0] = temp;
//                counterClockWise(2);
                counterClockWiseBack();
            }
        }
    }

    private static void up(char ch) {
        if (ch == '+') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[3][i][0];
                cube[3][i][0] = cube[5][i][0];
                cube[5][i][0] = cube[2][2 - i][2];
                cube[2][2 - i][2] = cube[4][i][0];
                cube[4][i][0] = temp;
                clockWise(0);
            }
        } else if (ch == '-') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[3][i][0];
                cube[3][i][0] = cube[4][i][0];
                cube[4][i][0] = cube[2][2 - i][2];
                cube[2][2 - i][2] = cube[5][i][0];
                cube[5][i][0] = temp;
                counterClockWise(0);
            }
        }
    }

    private static void down(char ch) {
        if (ch == '+') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[3][i][2];
                cube[3][i][2] = cube[4][i][2];
                cube[4][i][2] = cube[2][2 - i][0];
                cube[2][2 - i][0] = cube[5][i][2];
                cube[5][i][2] = temp;
                clockWise(1);
            }
        } else if (ch == '-') {
            for (int i = 0; i < 3; i++) {
                char temp = cube[3][i][2];
                cube[3][i][2] = cube[5][i][2];
                cube[5][i][2] = cube[2][2 - i][0];
                cube[2][2 - i][0] = cube[4][i][2];
                cube[4][i][2] = temp;
                counterClockWise(1);
            }
        }
    }

    private static void clockWise(int num) {
        char[][] temp = new char[3][3];
        arrayCopy(cube[num], temp);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[num][i][j] = temp[j][2 - i];
            }
        }
    }

    private static void clockWiseBack() {
        char[][] temp = new char[3][3];
        arrayCopy(cube[2], temp);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[2][i][j] = temp[j][2 - i];
            }
        }
    }

    private static void counterClockWise(int num) {
        char[][] temp = new char[3][3];
        arrayCopy(cube[num], temp);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[num][i][j] = temp[2 - j][i];
            }
        }
    }

    private static void counterClockWiseBack() {
        char[][] temp = new char[3][3];
        arrayCopy(cube[2], temp);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[2][i][j] = temp[2 - j][j];
            }
        }
    }

    private static void arrayCopy(char[][] arr, char[][] copyArr) {
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, copyArr[i], 0, arr[i].length);
        }
    }

    private static void initCube() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i == 0) {
                        cube[i][j][k] = 'w';
                    } else if (i == 1) {
                        cube[i][j][k] = 'y';
                    } else if (i == 2) {
                        cube[i][j][k] = 'o';
                    } else if (i == 3) {
                        cube[i][j][k] = 'r';
                    } else if (i == 4) {
                        cube[i][j][k] = 'g';
                    } else if (i == 5) {
                        cube[i][j][k] = 'b';
                    }
                }
            }
        }
    }
}
