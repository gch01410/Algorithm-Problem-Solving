package Backjoon_online_judge.no2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //    static ArrayList<Integer>[] dp;
    static boolean[][] dp;
    static boolean[] map;
    static int n;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int edge = Integer.parseInt(st.nextToken());
//        dp = new ArrayList[n + 1];
        dp = new boolean[n + 1][n + 1];
        map = new boolean[n + 1];

//        for (int i = 1; i <= n; i++) {
//            dp[i] = new ArrayList<>();
//        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
//            dp[v1].add(v2);
//            dp[v2].add(v1);
            dp[v1][v2] = true;
            dp[v2][v1] = true;
        }
        map[1] = true;
        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int v) {

//        for (int i = 0; i < dp[v].size(); i++) {
//            if (!map[dp[v].get(i)]) {
//                map[dp[v].get(i)] = true;
//                count++;
//                dfs(dp[v].get(i));
//            }
//        }

        for (int i = 1; i <= n; i++) {
            if (dp[v][i] && !map[i]){
                map[i] = true;
                count++;
                dfs(i);
            }
        }
    }
}
