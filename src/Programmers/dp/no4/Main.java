package Programmers.dp.no4;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }

    private static int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] dp = new int[m + 1][n + 1];

        if (puddles.length != 0) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {

                    if (i == 1 && j == 1) {
                        dp[i][j] = 1;
                        continue;
                    }

                    boolean puddle = false;
                    for (int k = 0; k < puddles.length; k++) {
                        if (puddles[k][0] == i && puddles[k][1] == j) {
                            puddle = true;
                            break;
                        }
                    }
                    if (!puddle) {
                        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                    }
                }
            }
        } else {
            return factorial(m + n - 2) / factorial(m - 1) / factorial(n - 1);
        }

        answer = dp[m][n];

        return answer;
    }

    private static int factorial(int n) {
        int ans = 1;
        for (int i = n; i > 0; i--) {
            ans *= i;
        }
        return ans;
    }
}
