package Backjoon_online_judge.no15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static ArrayList<CCTV> list = new ArrayList<>();
    static ArrayList<Integer> dirs = new ArrayList<>();
    static int result = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
                if (map[j][i] >= 1 && map[j][i] <= 5) {
                    list.add(new CCTV(j, i, map[j][i]));
                }
            }
        }

        dfs(0);

        System.out.print(result);

    }

    private static void dfs(int index) {
        if (index == list.size()) {
            int[][] temp = init();
            for (int i = 0; i < index; i++) {
                int dir = dirs.get(dirs.size() - 1 - i);
                CCTV cctv = list.get(list.size() - 1- i);
                see(cctv, dir, temp);
            }
            result = Math.min(result, count(temp));

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.printf("%3d",temp[j][i]);
//                }
//                System.out.println();
//            }
//            System.out.println();
            return;
        }

        int num = list.get(index).num;

        if (num == 1 || num == 3 || num == 4) {
            for (int i = 0; i < 4; i++) {
                dirs.add(i);
                dfs(index + 1);
                dirs.remove(dirs.size() - 1);
            }
        } else if (num == 2) {
            for (int i = 0; i < 2; i++) {
                dirs.add(i);
                dfs(index + 1);
                dirs.remove(dirs.size() - 1);
            }
        } else if (num == 5) {
            dirs.add(0);
            dfs(index + 1);
            dirs.remove(dirs.size() - 1);
        }
    }


    private static void see(CCTV cctv, int dir, int[][] temp) {
        int num = cctv.num;
        int x = cctv.x;
        int y = cctv.y;
        if (num == 1) {
            if (dir == 0) {
                left(x, y, temp);
            } else if (dir == 1) {
                up(x, y, temp);
            } else if (dir == 2) {
                down(x, y, temp);
            } else if (dir == 3) {
                right(x, y, temp);
            }
        } else if (num == 2) {
            if (dir == 0) {
                left(x, y, temp);
                right(x, y, temp);
            } else if (dir == 1) {
                up(x, y, temp);
                down(x, y, temp);
            }
        } else if (num == 3) {
            if (dir == 0) {
                up(x, y, temp);
                right(x, y, temp);
            } else if (dir == 1) {
                up(x, y, temp);
                left(x, y, temp);
            } else if (dir == 2) {
                right(x, y, temp);
                down(x, y, temp);
            } else if (dir == 3) {
                left(x, y, temp);
                down(x, y, temp);
            }
        } else if (num == 4) {
            if (dir == 0) {
                left(x, y, temp);
                up(x, y, temp);
                right(x, y, temp);
            } else if (dir == 1) {
                up(x, y, temp);
                right(x, y, temp);
                down(x, y, temp);
            } else if (dir == 2) {
                left(x, y, temp);
                down(x, y, temp);
                right(x, y, temp);
            } else if (dir == 3) {
                up(x, y, temp);
                left(x, y, temp);
                down(x, y, temp);
            }
        } else if (num == 5) {
            up(x, y, temp);
            left(x, y, temp);
            right(x, y, temp);
            down(x, y, temp);
        }
    }

    private static int[][] init() {
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(map[i], 0, temp[i], 0, n);
        }
        return temp;
    }

    private static int count(int[][] temp) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void up(int x, int y, int[][] temp) {
        for (int i = y - 1; i >= 0; i--) {
            if (temp[x][i] == 6) {
                break;
            }
            if (temp[x][i] == 0) {
                temp[x][i] = -1;
            }
        }
    }

    private static void down(int x, int y, int[][] temp) {
        for (int i = y + 1; i < n; i++) {
            if (temp[x][i] == 6) {
                break;
            }
            if (temp[x][i] == 0) {
                temp[x][i] = -1;
            }
        }
    }

    private static void left(int x, int y, int[][] temp) {
        for (int i = x - 1; i >= 0; i--) {
            if (temp[i][y] == 6) {
                break;
            }
            if (temp[i][y] == 0) {
                temp[i][y] = -1;
            }
        }
    }

    private static void right(int x, int y, int[][] temp) {
        for (int i = x + 1; i < m; i++) {
            if (temp[i][y] == 6) {
                break;
            }
            if (temp[i][y] == 0) {
                temp[i][y] = -1;
            }
        }
    }
}

class CCTV {
    int x;
    int y;
    int num;

    public CCTV(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}
