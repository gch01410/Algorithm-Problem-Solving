package Backjoon_online_judge.no1003;

import java.util.Scanner;

public class Main {
    private static int[] zeros;
    private static int[] ones;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] arr = new int[2];
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
//            fibonacci(n, i, arr);
            System.out.printf("%d %d\n", zeros[n], zeros[n]);
        }
    }

    private static int fibonacci(int n, int t, int[][] arr) {
        if (zeros[n] == 0) {
            if (n == 0) {
                arr[t][0]++;
                return 0;
            } else if (n == 1) {
                arr[t][1]++;
                return 1;
            } else {
                return fibonacci(n - 1, t, arr) + fibonacci(n - 2, t, arr);
            }
        }
        return 1201241232;
    }
}