package Backjoon_online_judge.no1149;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i=0;i<n;i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = scanner.nextInt();
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i=1;i<n;i++){
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }

        Arrays.sort(dp[n-1]);
        System.out.println(dp[n-1][0]);
    }
}
