package Programmers.dp.no6;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,1}));
//        System.out.println(solution(new int[]{0, 0, 1000, 0, 0, 0, 1000}));
//        System.out.println(solution(new int[]{0, 0, 0, 0, 0, 0, 10, 20}));
    }

    private static int solution(int[] money) {
        int answer=0;
        int[] dp = new int[money.length];

        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = money[2] + dp[0];
        answer = Math.max(dp[1],dp[2]);
        for (int i = 3; i < money.length - 1; i++) {
            dp[i] = money[i] + Math.max(dp[i - 2], dp[i - 3]);
            answer = Math.max(answer,dp[i]);
        }

        dp[0] = 0;
        dp[2] = money[2];
        for (int i = 3; i < money.length; i++) {
            dp[i] = money[i] + Math.max(dp[i - 2], dp[i - 3]);
            answer = Math.max(answer,dp[i]);
        }

        return answer;
    }
}
