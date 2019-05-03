package Programmers.dp.no7;

public class Main {
    private static int[][] dp;
    public static void main(String[] args) {
        System.out.println(solution(1650, new int[][]{{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}}));
//        System.out.println(solution(3000, new int[][]{{1000, 2000, 300, 700}, {1100, 1900, 400, 900}, {900, 1800, 400, 700}, {1200, 2300, 500, 1200}}));
    }

    private static int solution(int K, int[][] travel) {
        int answer = 0;
        dp = new int[travel.length + 1][K + 1];
        answer = dfs(K, travel, 0, 0);

        return answer;
    }

    private static int dfs(int K, int[][] travel, int n, int time) {
        if (n == travel.length) {
            return 0;
        }
        if (dp[n][time] != 0) {
            return dp[n][time];
        }
        if (time + travel[n][0] <= K) {
            dp[n][time] = dfs(K, travel, n + 1, time + travel[n][0])+ travel[n][1];
        }
        if (time + travel[n][2] <= K) {
            dp[n][time] = Math.max(dfs(K, travel, n + 1, time + travel[n][2]) + travel[n][3], dp[n][time]);
        }

        return dp[n][time];
    }
}
