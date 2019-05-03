package Programmers.summer2017.no2;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}));
        System.out.println(solution(new int[]{4}));
        System.out.println(solution(new int[]{4, 7}));
        System.out.println(solution(new int[]{4, 7, 5}));
        System.out.println(solution(new int[]{4, 7, 5, 3}));
    }

    private static int solution(int sticker[]) {
        int answer = 0;

        if (sticker.length == 1) {
            return sticker[0];
        }
        if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int[] dp = new int[sticker.length];

        dp[0] = sticker[0];
        dp[1] = sticker[1];
        dp[2] = dp[0] + sticker[2];
        answer = Math.max(dp[1],dp[2]);
        for (int i = 3; i < sticker.length-1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + sticker[i];
            answer = Math.max(answer,dp[i]);
        }

        dp[0] = 0;
        dp[2] = sticker[2];
        for (int i = 3; i < sticker.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + sticker[i];
            answer = Math.max(answer,dp[i]);
        }

        return answer;
    }
}
