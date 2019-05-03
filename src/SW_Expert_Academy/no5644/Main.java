package SW_Expert_Academy.no5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] pos = new int[2][2];
    static int[][] dir;
    static int[][] bc;
    static ArrayList<Integer> aBc = new ArrayList<>();
    static ArrayList<Integer> bBc = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());
        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            pos[0][0] = 1;
            pos[0][1] = 1;
            pos[1][0] = 10;
            pos[1][1] = 10;
            dir = new int[2][m + 1];
            bc = new int[a][4];
            int sum = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= m; i++) {
                dir[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= m; i++) {
                dir[1][i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                bc[i][0] = Integer.parseInt(st.nextToken());
                bc[i][1] = Integer.parseInt(st.nextToken());
                bc[i][2] = Integer.parseInt(st.nextToken());
                bc[i][3] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i <= m; i++) {
                move(0, dir[0][i]);
                move(1, dir[1][i]);
                int max = 0;

                for (int j = 0; j < a; j++) {
                    if (Math.abs(pos[0][0] - bc[j][0]) + Math.abs(pos[0][1] - bc[j][1]) <= bc[j][2]) {
                        aBc.add(j);
                    }
                    if (Math.abs(pos[1][0] - bc[j][0]) + Math.abs(pos[1][1] - bc[j][1]) <= bc[j][2]) {
                        bBc.add(j);
                    }
                }
                if (aBc.size() != 0 && bBc.size() != 0) {
                    for (int j = 0; j < aBc.size(); j++) {
                        for (int k = 0; k < bBc.size(); k++) {

                            if (aBc.get(j) == bBc.get(k)) {
                                max = Math.max(max, bc[aBc.get(j)][3]);
                            } else {
                                max = Math.max(max, bc[aBc.get(j)][3] + bc[bBc.get(k)][3]);
                            }

                        }
                    }
                } else if (aBc.size() == 0 && bBc.size() != 0) {
                    for (int j = 0; j < bBc.size(); j++) {
                        max = Math.max(max, bc[bBc.get(j)][3]);
                    }
                } else if (aBc.size() != 0 && bBc.size() == 0) {
                    for (int j = 0; j < aBc.size(); j++) {
                        max = Math.max(max, bc[aBc.get(j)][3]);
                    }
                } else {

                }
                sum += max;

                aBc.clear();
                bBc.clear();
            }
            System.out.println("#" + (t + 1) + " " + sum);
        }
    }

    private static void move(int human, int dir) {
        switch (dir) {
            case 1:
                pos[human][1]--;
                break;
            case 2:
                pos[human][0]++;
                break;
            case 3:
                pos[human][1]++;
                break;
            case 4:
                pos[human][0]--;
                break;
        }
    }
}
