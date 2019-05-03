package Backjoon_online_judge.no12865;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxMassive = scanner.nextInt();
        List<Integer> massives = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            massives.add(scanner.nextInt());
            values.add(scanner.nextInt());
        }
        int[][] dp = new int[n+1][maxMassive+1];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0, maxMassive, massives, values,dp));
    }

    private static int dfs(int m, int n, int max, List<Integer> massive, List<Integer> value, int[][] dp) {
        if (m > max) {
            return -value.get(n - 1);
        }
        if (n >= massive.size()) {
            return 0;
        }
        if (dp[n][m]>=0){
            return dp[n][m];
        }
        return dp[n][m] = Math.max(dfs(m + massive.get(n), n + 1, max, massive, value,dp) + value.get(n), dfs(m, n + 1, max, massive, value,dp));
    }
}
