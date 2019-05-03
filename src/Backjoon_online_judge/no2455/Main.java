package Backjoon_online_judge.no2455;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[4][2];
        int[] sum = new int[4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        sum[0] = arr[0][1];
        sum[1] = sum[0] + arr[1][1] - arr[1][0];
        sum[2] = sum[1] + arr[2][1] - arr[2][0];
        sum[3] = sum[2] + arr[3][1] - arr[3][0];

        int max = 0;
        for (int i = 0;i<4;i++){
            if (max < sum[i]){
                max = sum[i];
            }
        }
        System.out.print(max);
    }
}
