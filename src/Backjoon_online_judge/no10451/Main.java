package Backjoon_online_judge.no10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(st.nextToken());
        arr = new int[test_case][1001];
        visit = new int[test_case][1001];

        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int count = 0;

            for (int i = 1; i <= n; i++) {
                arr[t][i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (visit[t][i] == 0) {
                    dfs(t, i);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void dfs(int t, int v) {
        visit[t][v] = 1;
        if (visit[t][arr[t][v]] == 1) {
            return;
        }
        dfs(t, arr[t][v]);
    }
}
