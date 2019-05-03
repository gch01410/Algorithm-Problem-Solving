package Backjoon_online_judge.no1932;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j=0;j<i+1;j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        dp[0][0] = arr[0][0];

        for (int i=1;i<n;i++){
            for (int j=0;j<i+1;j++){
                if (j==0){
                    dp[i][j] = arr[i][j] + dp[i-1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        int max=0;
        for (int i=0;i<n;i++){
            max = Math.max(max,dp[n-1][i]);
        }

        System.out.println(max);
    }
}
