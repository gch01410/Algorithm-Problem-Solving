package SW_Expert_Academy.no4014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static double[][] map1;
    static double[][] map2;
    static int n;
    static int x;
    static ArrayList<Integer> list = new ArrayList<>();
    static double[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());
        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            map1 = new double[n][n];
            map2 = new double[n][n];
            int result = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    double index = Double.parseDouble(st.nextToken());
                    map1[j][i] = index;
                    map2[i][j] = index;
                }
            }


//            int cnt = getNumberGSR(new double[]{3,3,3,2,1,1});
//            if (cnt >= 1) {
//                System.out.println(isHSR(buildGSR(new double[]{3,3,3,2,1,1})));
//            } else if (cnt == 0) {
//                System.out.println(isHSR(new double[]{3,3,3,2,1,1}));
//            }
            for (int i = 0; i < n; i++) {
                int cnt1 = getNumberGSR(map1[i]);
                int cnt2 = getNumberGSR(map2[i]);
                if (cnt1 >= 1) {
                    if (isHSR(buildGSR(map1[i]))) {
                        result++;
                    }
                } else if (cnt1 == 0) {
                    if (isHSR(map1[i])) {
                        result++;
                    }
                }
                if (cnt2 >= 1) {
                    if (isHSR(buildGSR(map2[i]))) {
                        result++;
                    }
                } else if (cnt2 == 0) {
                    if (isHSR(map2[i])) {
                        result++;
                    }
                }

            }

            System.out.println("#" + (t + 1) + " " + result);
        }
    }

    private static int getNumberGSR(double[] arr) {
        list.clear();
        int sum = 0;
        for (int i = 0; i <= n - x; i++) {
            int count = 0;
            double height = arr[i];
            boolean stat = false;
            for (int j = 0; j < x; j++) {
                if (arr[i + j] != height) {
                    stat = true;
                    break;
                }
            }

            if (i + x < n && !stat && arr[i + x] == height + 1) {
                sum++;
                count++;
                list.add(i);
            }
            if (i >= 1 && !stat && arr[i - 1] == height + 1) {
                sum++;
                count++;
                list.add(i);
            }

            if (count > 1) {
                list.clear();
                return -1;  // 경사로가 한곳에 2개이상 지을 수 있음 -> 나가리
            }
        }
        return sum;
    }

    private static double[] buildGSR(double[] arr) {
        temp = new double[n];
        System.arraycopy(arr, 0, temp, 0, temp.length);
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i);
            for (int j = 0; j < x; j++) {
                temp[index + j] += 0.5;
            }
        }

        return temp;
    }

    private static boolean isHSR(double[] temp) {
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(temp[i] - temp[i + 1]) >= 1) {
                return false;
            }
        }
        return true;
    }
}
