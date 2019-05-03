package Programmers.dp.no3;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}}));
    }

    private static int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;
        int[][] dp = new int[n][n];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        answer = max;

        return answer;
    }
}
